package scraper.templatescraper.templates;

import org.jsoup.Jsoup;
import scraper.Scraper;
import scraper.exceptions.ScraperNotInitializedException;
import scraper.html.HtmlElement;
import scraper.templatescraper.ArticleTemplate;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * An implementation of an ArticleTemplate made to serve as an example of how a template could be implemented.
 * The template is made to scrape articles from the website snl.no.
 *
 * @author Vetle Jahr
 * @version 1.0
 * @see ArticleTemplate
 */
public class SnlArticleTemplate extends ArticleTemplate {
    private Scraper scraper;

    /**
     * Sets the source for the templateScrper as a URL. SnlArticleTemplate only supports URL as a source as it is made
     * to scrape articles from snl.no.
     *
     * @param url URL for the source of the templateScraper
     */
    public SnlArticleTemplate(String url) {
        super();
        setSourceAsUrl(url);
        try {
            scraper = getScraper();
        } catch (ScraperNotInitializedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getIntroduction() {
        return scraper.getElementsFromTag("p").get(0).getText();
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
}
