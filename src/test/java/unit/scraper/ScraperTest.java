package unit.scraper;

import org.junit.jupiter.api.Test;
import scraper.Scraper;
import scraper.html.HtmlDocument;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ScraperTest {

    @Test
    void buildScraperWithString() {
        Scraper scraper = Scraper.buildScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertNotNull(scraper);
        assertSame(scraper.getClass(), Scraper.class);
    }

    @Test
    void getRawContent() {
        Scraper scraper = Scraper.buildScraperWithString("""
                <html>
                <head></head>
                <body>
                <h1>Hello World</h1>
                </body>
                </html>
                """);
        assertEquals(("""
                <html>
                <head></head>
                <body>
                <h1>Hello World</h1>
                </body>
                </html>
                """).trim(), scraper.getRawContent().trim());
    }

    @Test
    void getContentDocumentObject() {
        Scraper scraper = Scraper.buildScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertSame(scraper.getContentDocumentObject().getClass(), HtmlDocument.class);
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