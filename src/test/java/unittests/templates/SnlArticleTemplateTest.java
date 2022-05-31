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
}