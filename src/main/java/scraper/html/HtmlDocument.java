package scraper.html;

import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.event.DocumentEvent;

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
        return this._jsoupInternalDocument.title();
    }
}