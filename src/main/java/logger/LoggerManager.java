package logger;

import java.util.LinkedList;
import java.util.List;

public class LoggerManager {
    private final List<CustomLogger> loggerList;
    private final Level globalLevel;

    public LoggerManager(final Level globalLevel) {
        this.loggerList = new LinkedList<>();
        this.globalLevel = globalLevel;
    }

    public void addLogger(final CustomLogger logger) {
        loggerList.add(logger);
    }

    public Level getGlobalLevel() {
        return globalLevel;
    }
}
