package univers;

/**
 * Custom exception class to represent insufficient MP (Mana Points) exception.
 */
public class InsufficientHpException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientHpException(String message) {
        super(message);
    }
}