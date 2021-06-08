package epamqasejavaexceptions.exceptions;

/**
 * Thrown to indicate that student's score is out of range.
 * <p>
 * Applications can subclass this class to indicate similar exceptions.
 *
 * @author Anton Kudryavtsev
 */

public class IncorrectScoreException extends Exception {
    public IncorrectScoreException() {
    }

    public IncorrectScoreException(String message) {
        super(message);
    }

    public IncorrectScoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectScoreException(Throwable cause) {
        super(cause);
    }
}
