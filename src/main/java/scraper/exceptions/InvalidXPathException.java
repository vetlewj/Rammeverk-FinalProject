package scraper.exceptions;

public class InvalidXPathException extends Exception {
    public InvalidXPathException() {
        super("XPath is invalid");
    }

    public InvalidXPathException(String message) {
        super(message);
    }
}
