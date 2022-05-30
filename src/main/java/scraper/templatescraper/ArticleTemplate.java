package scraper.templatescraper;

import scraper.html.HtmlElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents an article template.
 *
 * @author Vetle Jahr
 * @version 1.0
 */
public abstract class ArticleTemplate extends TemplateScraper {
    /**
     * Gets the header of the article.
     *
     * @return header of the article
     */
    public abstract String getHeader();

    /**
     * Gets the introduction of the article.
     *
     * @return introduction of the article
     */
    public abstract String getIntroduction();

    /**
     * Gets the paragraphs of the article as an arraylist of HtmlElement.
     *
     * @return paragraphs of the article
     */
    public abstract ArrayList<HtmlElement> getParagraphs();

    /**
     * Gets the text content of the article as a hashmap with the header as key and the text as value.
     *
     * @return text content of the article
     */
    public abstract HashMap<String, String> getTextContentWithHeaders();

    /**
     * Gets the writers of the article.
     *
     * @return writers of the article
     */
    public abstract ArrayList<String> getWriters();

    /**
     * Gets the date the article was published. Similar to {@link #getDateTimePublished() getDateTimePublished()} but
     * returns only the date as a LocalDate object.
     *
     * @return date the article was published
     */
    public abstract LocalDate getDatePublished();

    /**
     * Gets the date and time the article was published. Similar to {@link #getDatePublished() getDatePublished()} but
     * returns the date and time as a LocalDateTime object.
     *
     * @return date and time the article was published
     */
    public abstract LocalDateTime getDateTimePublished();

    /**
     * Gets the date the article was last updated. Similar to {@link #getDateTimeLastUpdated() getDateTimeLastUpdated()}
     * but returns only the date as a LocalDate object.
     *
     * @return date the article was last updated
     */
    public abstract LocalDate getDateLastUpdated();

    /**
     * Gets the date and time the article was last updated. Similar to {@link #getDateLastUpdated() getDateLastUpdated()}
     * but returns the date and time as a LocalDateTime object.
     *
     * @return date and time the article was last updated
     */
    public abstract LocalDateTime getDateTimeLastUpdated();
}
