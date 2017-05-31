package de.zebrajaeger.buildsign;

/**
 * @author Lars Brandt
 */
public class BuildSignException extends Exception {
    public BuildSignException() {
    }

    public BuildSignException(String message) {
        super(message);
    }

    public BuildSignException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildSignException(Throwable cause) {
        super(cause);
    }
}
