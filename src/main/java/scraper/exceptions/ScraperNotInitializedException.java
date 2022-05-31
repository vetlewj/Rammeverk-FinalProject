package scraper.exceptions;

/**
 * Exception thrown when a Scraper is requested, but is not yet initialized.
 * @author Vetle Jahr
 * @version 1.0
 */
public class ScraperNotInitializedException extends Exception {
    /**
     * Constructs a new exception with a default message.
     */
    public ScraperNotInitializedException() {
        super("Scraper has not been initialized");
    }

    /**
     * Constructs a new exception with a custom message.
     * @param message The message to be displayed.
     */
    public ScraperNotInitializedException(String message) {
        super(message);
    }
}
