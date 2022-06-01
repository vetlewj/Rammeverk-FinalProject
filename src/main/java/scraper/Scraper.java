package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scraper.exceptions.InvalidSourceException;
import scraper.exceptions.InvalidXPathException;
import scraper.html.HtmlDocument;
import scraper.html.HtmlElement;
import scraper.xpathparser.XPathParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Scraper is a class that can be used to scrape HTML content from a URL, String or File. An instance of the Scraper
 * class can be created with a URL, String or File through {@link #createScraperWithURL(String) buildScraperWithURL},
 * {@link #createScraperWithString(String) buildScraperWithString} or
 * {@link #createScraperWithHtmlFile(File) buildScraperWithHtmlFile}.
 *
 * @author Vetle Jahr
 * @version 1.0
 */
public class Scraper {
    private enum SourceType {URL, STRING}

    private Document jsoupInternalDocument;
    private HtmlDocument content;

    private Scraper() {
    }

    /**
     * Private constructor to instantiate a new Scraper object with a URL or a String. Method is private as Scraper
     * objects are intended to be instantiated with a factory pattern using
     * {@link #createScraperWithURL(String) buildScraperWithUrl} and
     * {@link #createScraperWithString(String) buildScraperWithString} methods.
     *
     * @param source     Source for the Scraper to use, either a String to Scraper or a URL for a website to scrape
     * @param sourceType Enum type of source for the scraper to differentiate between String and URL
     */
    private Scraper(String source, SourceType sourceType) {
        if (sourceType == SourceType.STRING) {
            this.jsoupInternalDocument = parseStringToHtmlPage(source);
            setContent();
        } else if (sourceType == SourceType.URL) {
            try (InputStream in = new URL(source).openStream()) {
                this.jsoupInternalDocument = parseStringToHtmlPage(new String(in.readAllBytes(), StandardCharsets.UTF_8));
                setContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Private constructor to instantiate a new Scraper object with a File. Method is private as Scraper objects are
     * intended to be instantiated with a factory pattern using
     * {@link #createScraperWithHtmlFile(File) BuildScraperWithFile} method.
     *
     * @param file file for the Scraper to use as Source for the content
     */
    private Scraper(File file) {
        this.jsoupInternalDocument = parseFileToHtmlPage(file);
        setContent();
    }

    /**
     * Sets the content of the Scraper object.
     */
    private void setContent() {
        this.content = new HtmlDocument(this.jsoupInternalDocument);
    }

    /**
     * Reads a file and parses the content in a Document object.
     *
     * @param file File to read into Document object.
     * @return Document object with parsed content or null object if error occurs.
     */
    private Document parseFileToHtmlPage(File file) {
        try {
            return Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A method for creating a Scraper object with a URL using a builder pattern.
     *
     * @param url URL for the website to use the Scraper object on
     * @return Scraper Object built with the specified url
     */
    public static Scraper createScraperWithURL(String url) {
        return new Scraper(url, SourceType.URL);
    }

    /**
     * Method for creating a Scraper object with an HTML string using a builder pattern
     *
     * @param htmlString String in HTML format to use the Scraper object on
     * @return Scraper Object built with a specified String.
     */
    public static Scraper createScraperWithString(String htmlString) {
        return new Scraper(htmlString, SourceType.STRING);
    }

    /**
     * Creates a Scraper Object with an HTML file using a builder pattern
     *
     * @param file html-file to use the Scraper object on
     * @return Scraper object built with a specified file.
     */
    public static Scraper createScraperWithHtmlFile(File file) {
        try {
            if (!Files.probeContentType(file.toPath()).equals("text/html")) {
                throw new InvalidSourceException("File is not HTML, please provide a valid HTML file");
            }
            else {
                return new Scraper(file);
            }
        } catch (IOException | InvalidSourceException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the content of the Scraper in raw format.
     *
     * @return Raw output of HTML string, file or url
     */
    public String getRawContent() {
        return this.content.toString();
    }

    /**
     * Get HtmlDocument object of the scraper
     *
     * @return HtmlDocument object of content.
     */
    public HtmlDocument getContentDocumentObject() {
        return this.content;
    }

    /**
     * Reads a String and parses the content of HtmlDocument object.
     *
     * @param source Source String to parse
     * @return Document object with parsed content
     */
    private Document parseStringToHtmlPage(String source) {
        return Jsoup.parse(source);
    }

    /**
     * Get list of HtmlElements from site based on tag name.
     *
     * @param htmlTag name of the html tag to retrieve.
     * @return ArrayList of HtmlElements from requested tag.
     */
    public ArrayList<HtmlElement> getElementsFromTag(String htmlTag) {
        Elements elements = jsoupInternalDocument.getElementsByTag(htmlTag);
        ArrayList<HtmlElement> htmlElements = new ArrayList<>();
        for (Element el : elements) {
            htmlElements.add(HtmlElement.ElementToHtmlElement(el));
        }
        return htmlElements;
    }

    /**
     * Gets a list of HtmlElements from the site based on the value of the class attribute of the Html tag.
     *
     * @param className Value of the class attribute of the html tags to retrieve.
     * @return ArrayList of HtmlElements with the requested class attribute.
     */
    public ArrayList<HtmlElement> getElementsFromClass(String className) {
        Elements elements = jsoupInternalDocument.getElementsByClass(className);
        ArrayList<HtmlElement> htmlElements = new ArrayList<>();
        for (Element el : elements) {
            htmlElements.add(HtmlElement.ElementToHtmlElement(el));
        }
        return htmlElements;
    }

    /**
     * Gets a list of HtmlElements from the site base on the specified XPath.
     *
     *
     * @param xPath XPath to retrieve elements from.
     * @return ArrayList of HtmlElements from the XPath.
     * @throws InvalidXPathException if the XPath is invalid.
     */
    public ArrayList<HtmlElement> getElementsByXpath(String xPath) throws InvalidXPathException {
        Elements elements = jsoupInternalDocument.select(XPathParser.convertXPathToCssSelector(xPath));
        ArrayList<HtmlElement> htmlElements = new ArrayList<>();
        for (Element el : elements) {
            htmlElements.add(HtmlElement.ElementToHtmlElement(el));
        }
        return htmlElements;
    }

    /**
     * Gets a HtmlElement object based on the specified XPath.
     *
     * @param xPath XPath to use to retrieve the HtmlElement object.
     * @return HtmlElement object with the specified XPath.
     * @throws InvalidXPathException if the specified XPath is invalid.
     */
    public HtmlElement getElementByXpath(String xPath) throws InvalidXPathException {
        Elements elements = jsoupInternalDocument.select(XPathParser.convertXPathToCssSelector(xPath));
        return HtmlElement.ElementToHtmlElement(elements.first());
    }

    /**
     * Gets a HtmlElement object based on the specified CssSelector string.
     *
     * @param cssSelector String to define the path to the HtmlElement object using Css Selector syntax.
     * @return HtmlElement object with the specified CssSelector.
     */
    public HtmlElement getElementByCssSelector(String cssSelector) {
        Elements elements = jsoupInternalDocument.select(cssSelector);
        return HtmlElement.ElementToHtmlElement(elements.first());
    }

    /**
     * Gets a list of HtmlElement objects based on the specified CssSelector string.
     *
     * @param cssSelector String to define the path to the HtmlElement objects using Css Selector syntax.
     * @return ArrayList of HtmlElement objects with the specified CssSelector.
     */
    public ArrayList<HtmlElement> getElementsByCssSelector(String cssSelector) {
        Elements elements = jsoupInternalDocument.select(cssSelector);
        ArrayList<HtmlElement> htmlElements = new ArrayList<>();
        for (Element el : elements) {
            htmlElements.add(HtmlElement.ElementToHtmlElement(el));
        }
        return htmlElements;
    }

    /**
     * Gets an HtmlElement on the site based on the ID attribute.
     *
     * @param id id attribute of the HtmlElement
     * @return Element found based on id attribute of the Html tag.
     */
    public HtmlElement getElementById(String id) {
        return HtmlElement.ElementToHtmlElement(jsoupInternalDocument.getElementById(id));
    }

    /**
     * The title of the site.
     *
     * @return the title of the site as a string.
     */
    public String getTitle() {
        return jsoupInternalDocument.title();
    }
}