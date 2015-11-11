package converter;

/**
 * Exception that is thrown when a string that should represent either a number
 * (Arabic or Roman) is malformed.
 * 
 * @version Nov 6, 2015
 */
@SuppressWarnings("serial")
public class MalformedNumberException extends Exception {

    /**
     * Constructor with a descriptive message for the Exception.
     * 
     * @param message The descriptive message
     */
    public MalformedNumberException(String message) {
        super(message);
    }
}
