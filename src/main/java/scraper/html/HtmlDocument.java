package scraper.html;

import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.event.DocumentEvent;

public class HtmlDocument extends Document{
    HtmlElement head;
    HtmlElement body;
    String title;

    /**
     * Create a new, empty Document.
     *
     * @param baseUri base URI of document
     * @see Jsoup#parse
     * @see #createShell
     */
    public HtmlDocument(@Nullable String baseUri) {
        super(baseUri);
    }


    public static HtmlDocument documentToHtmlDocument(Document document){
        return HtmlDocumentParser.documentToHtmlDocument(document);
    }

    public HtmlElement getHead() {
        return head;
    }

    public void setHead(HtmlElement head) {
        this.head = head;
    }

    public HtmlElement getBody() {
        return body;
    }

    public void setBody(HtmlElement body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
