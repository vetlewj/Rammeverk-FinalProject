package unittests.scraper;

import org.junit.jupiter.api.Test;
import scraper.Scraper;
import scraper.exceptions.InvalidXPathException;
import scraper.html.HtmlDocument;
import scraper.html.HtmlElement;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ScraperTest {

    @Test
    void buildScraperWithString() {
        Scraper scraper = Scraper.createScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertNotNull(scraper);
        assertSame(scraper.getClass(), Scraper.class);
    }

    @Test
    void getRawContent() {
        Scraper scraper = Scraper.createScraperWithString("""
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
        Scraper scraper = Scraper.createScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertSame(scraper.getContentDocumentObject().getClass(), HtmlDocument.class);
    }

    @Test
    void getElementsFromTag() {
        Scraper scraper = Scraper.createScraperWithString("<html><body><h1>Hello World</h1></body></html>");
        assertEquals(1, scraper.getElementsFromTag("h1").size());
        assertEquals("Hello World", scraper.getElementsFromTag("h1").get(0).getText());
    }

    @Test
    void getElementsFromClass() {
    }

    @Test
    void getElementsByXpath() {
    }

    @Test
    void getElementByXpath() {
        File testFile = new File("src/test/resources/snlMichelangelo.html");
        Scraper scraper = Scraper.createScraperWithHtmlFile(testFile);
        try {
            HtmlElement element = scraper.getElementByXpath("//span[@class=\"page-title__heading-text\"]");
            assertEquals("Michelangelo", element.getStringContentOfCurrentElement());
        } catch (InvalidXPathException e) {
            System.out.println("Invalid XPath");;
        }

    }

    @Test
    void getElementById() {
    }

    @Test
    void getTitle() {
    }
}