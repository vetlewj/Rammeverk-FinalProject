package scraper.html;

import java.util.ArrayList;
import java.util.HashMap;

/** Represents a HTML Tag.
 * @author Vetle Jahr
 * @version %I%, %G%
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

    @Override
    public String toString() {
        return content;
    }
}
