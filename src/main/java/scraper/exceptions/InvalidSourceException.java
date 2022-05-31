package scraper.exceptions;

/**
 * Exception thrown when an invalid Source is provided. An invalid source is a source that is not supported by the
 * Scraper. As of version 1.0, the Scraper supports URL, File and String sources.
 * @author Vetle Jahr
 * @version 1.0
 */
public class InvalidSourceException extends Throwable {

    /**
     * Construcsts an error message with a specfied message.
     *
     * @param message The message to be displayed.
     */
    public InvalidSourceException(String message) {
        super(message);
    }
}
