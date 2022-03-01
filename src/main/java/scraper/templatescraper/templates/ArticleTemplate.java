package scraper.templatescraper.templates;

import scraper.HTML.HtmlElement;
import scraper.templatescraper.TemplateScraper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public interface ArticleTemplate extends TemplateScraper {
    String getHeader();
    String getIntroduction();
    ArrayList<HtmlElement>getParagraphs();
    HashMap<String, String> getTextContentWithHeaders();
    ArrayList<String> getWriters();
    LocalDate getDatePublished();
    LocalDateTime getDateTimePublished();
    LocalDate getDateLastUpdated();
    LocalDateTime getDateTimeLastUpdated();
}
