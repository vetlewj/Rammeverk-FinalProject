package scraper.templatescraper.templates;

import org.jsoup.Jsoup;
import scraper.html.HtmlElement;
import scraper.templatescraper.ArticleTemplate;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class SnlArticleTemplate extends ArticleTemplate {
    @Override
    public String getHeader() {
        return null;
    }

    @Override
    public String getIntroduction() {
        return null;
    }

    @Override
    public ArrayList<HtmlElement> getParagraphs() {
        return null;
    }

    @Override
    public HashMap<String, String> getTextContentWithHeaders() {
        return null;
    }

    @Override
    public ArrayList<String> getWriters() {
        return null;
    }

    @Override
    public LocalDate getDatePublished() {
        return null;
    }

    @Override
    public LocalDateTime getDateTimePublished() {
        return null;
    }

    @Override
    public LocalDate getDateLastUpdated() {
        return null;
    }

    @Override
    public LocalDateTime getDateTimeLastUpdated() {
        return null;
    }

    @Override
    public File articleToJson() {
        return null;
    }
}
