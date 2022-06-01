package integrationtests;

import org.junit.jupiter.api.Test;
import scraper.Scraper;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ScraperFileTest {

    @Test
    void buildScraperWithHtmlFile(){
        File testFile = new File("src/test/resources/snlMichelangelo.html");
        Scraper scraper = Scraper.createScraperWithHtmlFile(testFile);
        assertNotNull(scraper);
        assertSame(scraper.getClass(), Scraper.class);
    }

}
