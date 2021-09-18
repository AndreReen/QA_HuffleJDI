package logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomLogger {

    private final LoggerManager manager;
    private final Class<?> clazz;
    private Level loggerLevel;

    public CustomLogger(final Class<?> clazz, final LoggerManager manager) {
        this.manager = manager;
        this.manager.addLogger(this);
        this.clazz = clazz;
        this.loggerLevel = manager.getGlobalLevel();
    }

    public CustomLogger(final Class<?> clazz, final LoggerManager manager, final Level level) {
        this.manager = manager;
        this.manager.addLogger(this);
        this.clazz = clazz;
        this.setLevel(level);
    }

    public void setLevel(Level level) {
        this.loggerLevel = level;
    }

    public void info(final Object message) {
        publish(Level.INFO, String.valueOf(message));
    }

    public void debug(final Object message) {
        publish(Level.DEBUG, String.valueOf(message));
    }

    public void warn(final Object message) {
        publish(Level.WARN, String.valueOf(message));
    }

    public void error(final Object message) {
        publish(Level.ERR, String.valueOf(message));
    }

    private void publish(final Level level, final String message) {
        if (this.loggerLevel.ordinal() <= level.ordinal()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                .append("[")
                .append(getCurrentTime())
                .append("]-[")
                .append(clazz.getSimpleName())
                .append("]-[")
                .append(level.name())
                .append("] : ")
                .append(message);
            System.out.println(stringBuilder);
        }
    }

    private String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return format.format(date);
    }
}
