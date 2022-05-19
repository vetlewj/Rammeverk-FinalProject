package unittests.scraper;

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
        // removes all the whitespace and newlines [\r\n\t\f\v ]
        assertEquals(("""
                <html>
                <head></head>
                <body>
                <h1>Hello World</h1>
                </body>
                </html>
                """).replaceAll("\\s+", ""),
                scraper.getRawContent().replaceAll("\\s+", ""));
    }

    @Test
    void getContentDocumentObject() {
        Scraper scraper = Scraper.buildScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertSame(scraper.getContentDocumentObject().getClass(), HtmlDocument.class);
    }

    @Test
    void getElementsFromTag() {
        Scraper scraper = Scraper.buildScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertEquals(1, scraper.getElementsFromTag("h1").size());
        assertEquals("Hello World", scraper.getElementsFromTag("h1").get(0).toString());
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