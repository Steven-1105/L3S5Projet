package univers;

/**
 * Custom exception class to represent insufficient MP (Mana Points) exception.
 */
public class InsufficientMpException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientMpException(String message) {
        super(message);
    }
}