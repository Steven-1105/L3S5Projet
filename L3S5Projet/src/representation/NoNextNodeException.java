package representation;

/**
 * Custom exception class representing the scenario where no next node is available in the game structure.
 * This exception is typically thrown when trying to proceed to the next node in the game, but the current node does not have a successor.
 */
public class NoNextNodeException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructs a new NoNextNodeException with null as its detail message.
     */
	public NoNextNodeException() {
        super();
    }

	/**
     * Constructs a new NoNextNodeException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     */
    public NoNextNodeException(String message) {
        super(message);
    }

    /**
     * Constructs a new NoNextNodeException with the specified detail message and cause.
     *
     * @param message The detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param cause The cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public NoNextNodeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new NoNextNodeException with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     *
     * @param cause The cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public NoNextNodeException(Throwable cause) {
        super(cause);
    }
}