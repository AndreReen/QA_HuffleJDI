package config;

public class Config {
    public static String getEnvVar(String string) {
        return System.getenv(string);
    }
}
