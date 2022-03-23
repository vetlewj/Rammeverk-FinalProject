package scraper.templatescraper;

import scraper.html.HtmlElement;
import scraper.templatescraper.TemplateScraper;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ArticleTemplate extends TemplateScraper {
    public abstract String getHeader();
    public abstract String getIntroduction();
    public abstract ArrayList<HtmlElement> getParagraphs();
    public abstract HashMap<String, String> getTextContentWithHeaders();
    public abstract ArrayList<String> getWriters();
    public abstract LocalDate getDatePublished();
    public abstract LocalDateTime getDateTimePublished();
    public abstract LocalDate getDateLastUpdated();
    public abstract LocalDateTime getDateTimeLastUpdated();

    public abstract File articleToJson();
}
