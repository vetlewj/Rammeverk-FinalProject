package scraper.templatescraper;

import scraper.Scraper;
import scraper.exceptions.ScraperNotInitializedException;

import java.io.File;

/**
 * TemplateScraper is an abstract class that provides a template for creating a Scraper made to scrape websites.
 * It provides a default implementation of some necessary methods for creating a TemplateScraper for various websites.
 * Examples of how to inherit from TemplateScraper are provided in the subclasses: {@link ArticleTemplate} and
 * {@link ProductTemplate}. The TemplateScraper is meant to be very easy to use once an implementation of it is provided
 * through inheritance.
 *
 * @author Vetle Jahr
 * @version 1.0
 */
public abstract class TemplateScraper {
    private enum SourceType {URL, FILE, STRING}

    /**
     * The various source types the TemplateScraper can use. The TemplateScraper can use a URL, a File or a String as
     * source.
     *
     * @author Vetle Jahr
     * @version 1.0
     */
    public enum TemplateSourceType {
        /**
         * URL source type.
         */
        URL,
        /**
         * File source type. The file must be an HTML file.
         */
        FILE,
        /**
         * String source type. The string must be an HTML string.
         */
        STRING}

    private Scraper scraper;

    private void setSource(String source, SourceType sourceType) {
        if (sourceType == SourceType.URL) {
            scraper = Scraper.createScraperWithURL(source);
        } else if (sourceType == SourceType.STRING) {
            scraper = Scraper.createScraperWithString(source);
        }
    }

    private void setSource(File file) {
        scraper = Scraper.createScraperWithHtmlFile(file);
    }

    /**
     * Sets the source for the templateScrper as a URL.
     *
     * @param url URL for the source of the templateScraper
     */
    public void setSourceAsUrl(String url) {
        setSource(url, SourceType.URL);
    }

    /**
     * Sets the source for the templateScrper as a html string.
     *
     * @param htmlString html string for the source of the templateScraper
     */
    public void setSourceAsString(String htmlString) {
        setSource(htmlString, SourceType.STRING);
    }

    /**
     * Sets the source for the templateScrper as a html file.
     *
     * @param file html file for the source of the templateScraper
     */
    public void setSourceAsFile(File file) {
        setSource(file);
    }

    /**
     * Gets Scraper object if Scraper object has been initialized
     *
     * @return Scraper object, returns null if Scraper object has not been initialized
     * @throws ScraperNotInitializedException if Scraper object has not been initialized.
     */
    public Scraper getScraper() throws ScraperNotInitializedException {
        if (scraper == null) {
            throw new ScraperNotInitializedException("Scraper has not been initialized, please set source");
        }
        return scraper;
    }


    /**
     * Method is used to build a custom TemplateScraper Object from a given template.
     *
     * @param template The template to use for the TemplateScraper
     * @param sourceType type of source for the template (URL, FILE, STRING)
     * @param source     source to scrape. depending on the sourceType:
     *                   URL - url to scrape
     *                   FILE - path of file to scrape
     *                   STRING - html string to scrape
     * @return TemplateScraper object
     */
    public static TemplateScraper buildCustomTemplate(TemplateScraper template, TemplateSourceType sourceType, String source) {
        if (sourceType == TemplateSourceType.URL) {
            template.setSourceAsUrl(source);
        } else if (sourceType == TemplateSourceType.FILE) {
            File sourceFile = new File(source);
            if (!sourceFile.exists()) {
                throw new IllegalArgumentException("File does not exist");
            }
            template.setSourceAsFile(sourceFile);
        } else if (sourceType == TemplateSourceType.STRING) {
            template.setSourceAsString(source);
        } else {
            throw new IllegalArgumentException("Invalid sourceType");
        }
        return template;
    }

    /**
     * Method is used to get the JSON representation of the object. Should be overridden by the child class.
     *
     * @return JSON representation of the object
     */
    public String toJson() {
        return getClass().toString();
    }
}
