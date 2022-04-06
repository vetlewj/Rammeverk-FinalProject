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

    private Document _jsoupInternalDocument;

    private HtmlElement head;
    private HtmlElement body;
    private String title;

    public HtmlDocument(Document document) {
        this._jsoupInternalDocument = document;
        this.head = HtmlElement.ElementToHtmlElement(_jsoupInternalDocument.head());
        this.body = HtmlElement.ElementToHtmlElement(_jsoupInternalDocument.body());
    }

    public HtmlElement getHead() {
        return head;
    }

    public HtmlElement getBody() {
        return body;
    }

    public String getTitle() {
        title = _jsoupInternalDocument.title();
        return title;
    }
}