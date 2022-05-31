package unittests.templates;

import org.junit.jupiter.api.Test;
import scraper.templatescraper.templates.SnlArticleTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SnlArticleTemplateTest {

    @Test
    void getTextContentWithHeaders() {
        SnlArticleTemplate snlArticleTemplate = new SnlArticleTemplate("https://snl.no/Michelangelo");
        HashMap<String, String> textContent = snlArticleTemplate.getTextContentWithHeaders();
        assertTrue(textContent.get("Biografier").contains("og Ascanio Condivi skrev biografier om Michelangelo."));
    }

    @Test
    void getWriters() {
        SnlArticleTemplate snlArticleTemplate = new SnlArticleTemplate("https://snl.no/Michelangelo");
        assertEquals("Thurid Vold (OsloMet)", snlArticleTemplate.getWriters().get(0));
    }

    @Test
    void getDatePublished() {
    }

    @Test
    void getDateTimePublished() {
    }

    @Test
    void getDateLastUpdated() {
    }

    @Test
    void getDateTimeLastUpdated() {
    }
}