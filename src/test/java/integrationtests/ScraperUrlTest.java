package integrationtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scraper.Scraper;
import scraper.templatescraper.templates.SnlArticleTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ScraperUrlTest {
    private Scraper scraper;

    public ScraperUrlTest() {
    }

    @BeforeEach
    public void initialize() {
        scraper = Scraper.createScraperWithURL("https://snl.no/Michelangelo");
    }

    @Test
    void buildScraperWithURL() {
        Scraper scraperFromUrl = Scraper.createScraperWithURL("https://www.google.com");
        assertNotNull(scraperFromUrl);
        assertSame(scraperFromUrl.getClass(), Scraper.class);
    }

    // Scenario 1: Set up a webscraper for https://snl.no/Michelangelo and retrieve all h1 elements
    @Test
    public void testGetAllH1Elements() {
        scraper.getElementsFromTag("h1");
        Assertions.assertEquals("Michelangelo", scraper.getElementsFromTag("h1").get(0).getText());
    }

    @Test
    public void initSnlArticleTemplate() {
        SnlArticleTemplate snlArticleTemplate = new SnlArticleTemplate("https://snl.no/Michelangelo");
        Assertions.assertEquals("Michelangelo", snlArticleTemplate.getHeader());
    }
}
