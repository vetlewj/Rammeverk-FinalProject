package scraper.html;

import org.jsoup.nodes.Document;


/**
 * Represents an HTML document.
 * A wrapper for the JSoup Document class.
 *
 * @author Vetle Jahr
 * @version 1.0
 */
public class HtmlDocument {

    private Document jsoupInternalDocument;

    private HtmlElement head;
    private HtmlElement body;
    private String title;

    /**
     * Creates a new HtmlDocument from a JSoup Document.
     * @param document JSoup Document to wrap.
     */
    public HtmlDocument(Document document) {
        this.jsoupInternalDocument = document;
        this.head = HtmlElement.ElementToHtmlElement(jsoupInternalDocument.head());
        this.body = HtmlElement.ElementToHtmlElement(jsoupInternalDocument.body());
    }

    /**
     * Returns the head element of the document.
     * @return The head element of the document.
     */
    public HtmlElement getHead() {
        return head;
    }

    /**
     * Returns the body element of the document.
     * @return The body element of the document.
     */
    public HtmlElement getBody() {
        return body;
    }

    /**
     * Returns the title of the document.
     * @return The title of the document.
     */
    public String getTitle() {
        title = jsoupInternalDocument.title();
        return title;
    }

    /**
     * Returns the document as a String.
     * @return The document as a String.
     */
    @Override
    public String toString() {
        return jsoupInternalDocument.toString();
    }
}