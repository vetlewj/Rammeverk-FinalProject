package scraper.templatescraper.templates;

import scraper.Scraper;
import scraper.exceptions.ScraperNotInitializedException;
import scraper.html.HtmlElement;
import scraper.templatescraper.ArticleTemplate;

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
        // Article section: class=l-article__section
        // Article header: class=l-article__subheading
        // Article text: class=l-article__body-text
        HashMap<String, String> textContent = new HashMap<>();
        ArrayList<HtmlElement> articleSections = scraper.getElementsFromClass("l-article__section");
        for (HtmlElement articleSection : articleSections) {
            if (articleSection.getElementsFromClass("l-article__subheading").size() > 0) {
                textContent.put(articleSection.getElementsFromClass("l-article__subheading").get(0).getText(),
                        articleSection.getElementsFromClass("l-article__body-text").get(0).getText());
            }
            else{
                textContent.put("No heading", articleSection.getElementsFromClass("l-article__body-text").get(0).getText());
            }
        }
        System.out.println(textContent.get("Biografier"));
        return textContent;
    }

    @Override
    public ArrayList<String> getWriters() {
        ArrayList<String> writers = new ArrayList<>();
        ArrayList<HtmlElement> elements = scraper.getElementsFromClass("article-info__author");
        for (HtmlElement element : elements) {
            writers.add(element.getText());
        }
        return writers;
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
