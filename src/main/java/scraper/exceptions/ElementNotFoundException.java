package scraper.exceptions;

/**
 * Exception thrown when an element is not found.
 */
public class ElementNotFoundException extends Exception {
    /**
     * Constructs a new exception with a default message.
     */
    public ElementNotFoundException() {
        super("Could not find Element");
    }

    /**
     * Constructs a new exception with a custom message.
     * @param message The message to be displayed.
     */
    public ElementNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with a custom message and the element that is not found.
     * @param message The message to be displayed.
     * @param object The element that was not found.
     */
    public ElementNotFoundException(String message, Object object) {
        super(message + " Element not found is: " + object);
    }
}
