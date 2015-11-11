package converter;

/**
 * Exception that is thrown when the number has a value that cannot be
 * represented by the extended Roman Numerals.
 * 
 * @version Nov 6, 2015
 */
@SuppressWarnings("serial")
public class ValueOutOfBoundsException extends Exception {

    /**
     * Constructor with a descriptive message for the Exception
     * 
     * @param message The descriptive message
     */
    public ValueOutOfBoundsException(String message) {
        super(message);
    }
}
