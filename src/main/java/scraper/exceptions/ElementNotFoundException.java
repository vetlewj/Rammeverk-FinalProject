package scraper.exceptions;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException() {
        super("Could not find Element");
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
    public ElementNotFoundException(String message, Object object) {
        super(message + " Element not found is: " + object);
    }
}
