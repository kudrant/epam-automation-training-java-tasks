package epamqasejavaexceptions.exceptions;

/**
 * Thrown to indicate that Faculty has no any Group in it.
 * <p>
 * Applications can subclass this class to indicate similar exceptions.
 *
 * @author Anton Kudryavtsev
 */

public class EmptyFacultyException extends Exception {
    public EmptyFacultyException() {
    }

    public EmptyFacultyException(String message) {
        super(message);
    }

    public EmptyFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyFacultyException(Throwable cause) {
        super(cause);
    }
}
