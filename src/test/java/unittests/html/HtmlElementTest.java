package unittests.html;

import org.junit.jupiter.api.Test;
import scraper.Scraper;
import scraper.html.HtmlElement;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertSame;

class HtmlElementTest {

    @Test
    void getAttribute() {
        //TODO: Fix failing test. Attribute is not being found. 
        File testFile = new File("src/test/resources/snlMichelangelo.html");
        Scraper scraper = Scraper.buildScraperWithHtmlFile(testFile);

        HtmlElement htmlElement = scraper.getElementsFromClass("page-title__heading-text").get(0);
        System.out.println(htmlElement);
        String attribute = htmlElement.getAttribute("class");
        assertSame("page-title__heading-text", attribute);
    }
}
