package scraper.html;

import java.util.ArrayList;
import java.util.HashMap;

public class HtmlElement {
    private String tag;
    private HashMap<String, String> attributes;
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
