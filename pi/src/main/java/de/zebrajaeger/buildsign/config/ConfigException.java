package de.zebrajaeger.buildsign.config;

/**
 * @author Lars Brandt
 */
public class ConfigException extends Exception {
    public ConfigException() {
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }
}
