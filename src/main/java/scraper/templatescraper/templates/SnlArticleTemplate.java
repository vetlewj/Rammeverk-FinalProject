package scraper.templatescraper.templates;

import scraper.Scraper;
import scraper.exceptions.InvalidXPathException;
import scraper.exceptions.ScraperNotInitializedException;
import scraper.html.HtmlElement;
import scraper.templatescraper.ArticleTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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

    /**
     * Gets the introduction of the article. The introduction is the first paragraph of the article.
     *
     * @return introduction of the article as a String.
     */
    @Override
    public String getIntroduction() {
        return scraper.getElementsByTag("p").get(0).getText();
    }

    /**
     * Gets the text content of the article as a hashmap with the header as key and the text as value.
     *
     * @return text content of the article as a hashmap
     */
    @Override
    public HashMap<String, String> getTextContentWithHeaders() {
        // Article section: class=l-article__section
        // Article header: class=l-article__subheading
        // Article text: class=l-article__body-text
        HashMap<String, String> textContent = new HashMap<>();
        ArrayList<HtmlElement> articleSections = scraper.getElementsByClass("l-article__section");
        for (HtmlElement articleSection : articleSections) {
            if (articleSection.getElementsByClass("l-article__subheading").size() > 0) {
                textContent.put(articleSection.getElementsByClass("l-article__subheading").get(0).getText(),
                        articleSection.getElementsByClass("l-article__body-text").get(0).getText());
            } else {
                textContent.put("No heading", articleSection.getElementsByClass("l-article__body-text").get(0).getText());
            }
        }
        return textContent;
    }

    /**
     * Gets the writers of the article.
     *
     * @return writers of the article
     */
    @Override
    public ArrayList<String> getWriters() {
        ArrayList<String> writers = new ArrayList<>();
        ArrayList<HtmlElement> elements = scraper.getElementsByClass("article-info__author");
        for (HtmlElement element : elements) {
            writers.add(element.getText());
        }
        return writers;
    }

    /**
     * Gets the date the article was published. Snl articles only display the date of when the article was last updated,
     * and not when the article was originally published, and therefore this method will return the date of the last
     * update. This method return the same as {@link #getDateLastUpdated() getDateLastUpdated()} and the Date of
     * {@link #getDateTimePublished() getDateTimePublished} and
     * {@link #getDateTimeLastUpdated() getDateTimeLastUpdated}.
     *
     * @return date the article was published
     */
    @Override
    public LocalDate getDatePublished() {
        return getDateTimePublished().toLocalDate();
    }

    /**
     * Gets the date and time the article was published. Snl articles only display the date of when the article was last updated,
     * and not when the article was originally published, and therefore this method will return the date of the last
     * update. This method return the same as {@link #getDateTimeLastUpdated() getDateTimeLastUpdated()}. If only the
     * date is needed, {@link #getDatePublished() getDatePublished()} should be used instead.
     *
     * @return date the article was published
     */
    @Override
    public LocalDateTime getDateTimePublished() {
        try {
            String datetime = scraper.getElementsByXpath("//dd[@class='article-info__item-value']/time").get(0).getAttributeValue("datetime");
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(datetime);
            return zonedDateTime.toLocalDateTime();
        } catch (InvalidXPathException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the date the article was last updated. Snl articles only display the date of when the article was last
     * updated, and not when the article was originally published. Therefore, this method will return the same as
     * {@link #getDatePublished() getDatePublished()}.
     *
     * @return date the article was last updated
     */
    @Override
    public LocalDate getDateLastUpdated() {
        return getDatePublished();
    }

    /**
     * Gets the date and time the article was last updated. Snl articles only display the date of when the article was last
     * updated, and not when the article was originally published. Therefore, this method will return the same as
     * {@link #getDateTimePublished() getDateTimePublished()}.
     *
     * @return date and time the article was last updated
     */
    @Override
    public LocalDateTime getDateTimeLastUpdated() {
        return getDateTimePublished();
    }
}
