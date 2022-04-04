package scraper.html;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Represents a HTML Tag.
 * @author Vetle Jahr
 * @version 1.0
 */
public class HtmlElement {
    private String tag;
    private HashMap<String, String> attributes;

    /**
     * Represents the child HTML elements. Only contains the direct children.
     */
    private ArrayList<HtmlElement> childElements;
    private String content;

    public HtmlElement() {
    }

    public HtmlElement(String tag, HashMap<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public HtmlElement getChildByXPath(String s) {
        return null;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<HtmlElement> getChildElements() {
        return childElements;
    }

    public void setChildElements(ArrayList<HtmlElement> childElements) {
        this.childElements = childElements;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
