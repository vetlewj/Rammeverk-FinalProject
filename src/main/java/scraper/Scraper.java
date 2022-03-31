package scraper;

import scraper.html.HtmlElement;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Vetle Jahr
 * @version %I%, %G%
 */
public class Scraper {
    private enum SourceType {URL, FILE, STRING}

    public Scraper() {
    }

    private Scraper(String source, SourceType sourceType) {

    }

    private Scraper(File f) {

    }

    /**
    * A method for creating a Scraper object with a URL using a builder pattern.
    *
    * @param url URL for the website to use the Scraper object on
    * @return Scraper Object built with the sepcified url
    */
    public static Scraper buildScraperWithURL(String url) {
        return new Scraper(url, SourceType.URL);
    }

    /**
     * Method for creating a Scraper object with an HTML string using a builder pattern
     *
     * @param htmlString String in HTML format to use the Scraper object on
     * @return Scraper Object built with a specified String.
     */
    public static Scraper buildScraperWithString(String htmlString) {
        return new Scraper(htmlString, SourceType.STRING);
    }

    /**
     * Creates a Scraper Object with an HTML file using a builder pattern
     *
     * @param file html-file to use the Scraper object on
     * @return Scraper object built with a specified file.
     */
    public static Scraper buildScraperWithHtmlFile(File file) {
        // TODO: Add check that file is .html
        return new Scraper(file);
    }

    public ArrayList<HtmlElement> getElementsFromTag(String htmlTag) {
        return null;
    }

    public ArrayList<HtmlElement> getElementsFromClass(String className) {
        return null;
    }

    public ArrayList<HtmlElement> getElementsByXpath(String xPath) {
        return null;
    }

    public HtmlElement getElementByXpath(String xPath) {
        return null;
    }

    public HtmlElement getElementById(String id) {
        return null;
    }

    public String getTitle() {
        return null;
    }
}