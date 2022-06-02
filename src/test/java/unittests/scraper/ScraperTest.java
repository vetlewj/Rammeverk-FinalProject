package unittests.scraper;

import org.junit.jupiter.api.Test;
import scraper.Scraper;
import scraper.exceptions.InvalidXPathException;
import scraper.exceptions.ScraperNotInitializedException;
import scraper.html.HtmlDocument;
import scraper.html.HtmlElement;

import java.io.File;
import java.util.ArrayList;

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
        assertEquals(1, scraper.getElementsByTag("h1").size());
        assertEquals("Hello World", scraper.getElementsByTag("h1").get(0).getText());
    }

    @Test
    void getElementsFromClass() {
    }

    @Test
    void getElementsByXpath() {
        Scraper scraper = Scraper.createScraperWithURL("https://www.nrk.no/nordland/blafrostfestivalen-reagerer_-saltdal-kommune-stenger-slipen-scene-1.15988754");
        String articleHeader = "";
        try {
             articleHeader = scraper.getElementsByXpath("//h1[@class=\"title title-large article-title\"]").get(0).getText();
        } catch (InvalidXPathException e) {
            e.printStackTrace();
        }
        assertTrue(articleHeader.contains("Kommune truet seg selv med bot"));
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