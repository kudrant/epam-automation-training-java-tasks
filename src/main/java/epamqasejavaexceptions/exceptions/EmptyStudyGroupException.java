package epamqasejavaexceptions.exceptions;

/**
 * Thrown to indicate that Group has no any Student in it.
 * <p>
 * Applications can subclass this class to indicate similar exceptions.
 *
 * @author Anton Kudryavtsev
 */

public class EmptyStudyGroupException extends Exception {
    public EmptyStudyGroupException() {
    }

    public EmptyStudyGroupException(String message) {
        super(message);
    }

    public EmptyStudyGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyStudyGroupException(Throwable cause) {
        super(cause);
    }
}
