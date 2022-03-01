package scraper.HTML;

import java.util.ArrayList;
import java.util.HashMap;

public class HtmlElement {
    private String tag;
    private HashMap<String, String> attributes;
    private ArrayList<HtmlElement> childElements;

    public HtmlElement() {
    }

    public HtmlElement(String tag, HashMap<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }
}
