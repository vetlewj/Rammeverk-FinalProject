package unittests.html;

import org.junit.jupiter.api.Test;
import scraper.Scraper;
import scraper.html.HtmlElement;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class HtmlElementTest {

    @Test
    void getAttribute() {
        File testFile = new File("src/test/resources/snlMichelangelo.html");
        Scraper scraper = Scraper.buildScraperWithHtmlFile(testFile);

        HtmlElement htmlElement = scraper.getElementsFromClass("page-title__heading-text").get(0);
        assertEquals("page-title__heading-text", htmlElement.getAttribute("class"));
    }
}
