package scraper.exceptions;

public class ScraperNotInitializedException extends Exception {
    public ScraperNotInitializedException() {
        super("Scraper has not been initialized");
    }

    public ScraperNotInitializedException(String message) {
        super(message);
    }
}
