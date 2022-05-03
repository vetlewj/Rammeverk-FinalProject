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

    public HtmlDocument(Document document) {
        this.jsoupInternalDocument = document;
        this.head = HtmlElement.ElementToHtmlElement(jsoupInternalDocument.head());
        this.body = HtmlElement.ElementToHtmlElement(jsoupInternalDocument.body());
    }

    public HtmlElement getHead() {
        return head;
    }

    public HtmlElement getBody() {
        return body;
    }

    public String getTitle() {
        title = jsoupInternalDocument.title();
        return title;
    }

    @Override
    public String toString() {
        return jsoupInternalDocument.toString();
    }
}