package scraper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScraperTest {

    @Test
    void buildScraperWithURL() {
        Scraper scraper = Scraper.buildScraperWithURL("https://www.google.com");
        assertNotNull(scraper);
    }

    @Test
    void buildScraperWithString() {
    }

    @Test
    void buildScraperWithHtmlFile() {
    }

    @Test
    void getRawContent() {
    }

    @Test
    void getContentDocumentObject() {
    }

    @Test
    void getElementsFromTag() {
    }

    @Test
    void getElementsFromClass() {
    }

    @Test
    void getElementsByXpath() {
    }

    @Test
    void getElementByXpath() {
    }

    @Test
    void getElementById() {
    }

    @Test
    void getTitle() {
    }
}