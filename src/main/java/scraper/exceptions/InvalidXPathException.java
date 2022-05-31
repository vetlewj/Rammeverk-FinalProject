package scraper.exceptions;

/**
 * Exception thrown when an invalid XPath is provided. An XPath is invalid if the Scraper can not parse the string.
 * @author Vetle Jahr
 * @version 1.0
 */
public class InvalidXPathException extends Exception {
    /**
     * Constructs a new ecpetion with a default message.
     */
    public InvalidXPathException() {
        super("XPath is invalid");
    }

    /**
     * Constructs a new exception with a custom message.
     * @param message The message to be displayed.
     */
    public InvalidXPathException(String message) {
        super(message);
    }
}
