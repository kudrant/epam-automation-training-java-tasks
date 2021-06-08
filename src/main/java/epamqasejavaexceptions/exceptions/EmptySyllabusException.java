package epamqasejavaexceptions.exceptions;

/**
 * Thrown to indicate that Student's syllabus contains no subjects.
 * <p>
 * Applications can subclass this class to indicate similar exceptions.
 *
 * @author Anton Kudryavtsev
 */

public class EmptySyllabusException extends Exception {
    public EmptySyllabusException() {
    }

    public EmptySyllabusException(String message) {
        super(message);
    }

    public EmptySyllabusException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptySyllabusException(Throwable cause) {
        super(cause);
    }
}
