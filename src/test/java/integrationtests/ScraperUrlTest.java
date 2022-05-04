package integrationtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scraper.Scraper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ScraperUrlTest {
    private Scraper scraper;

    public ScraperUrlTest() {
    }

    @BeforeEach
    public void initialize() {
        scraper = Scraper.buildScraperWithURL("https://snl.no/Michelangelo");
    }

    @Test
    void buildScraperWithURL() {
        Scraper scraperFromUrl = Scraper.buildScraperWithURL("https://www.google.com");
        assertNotNull(scraperFromUrl);
        assertSame(scraperFromUrl.getClass(), Scraper.class);
    }


}
