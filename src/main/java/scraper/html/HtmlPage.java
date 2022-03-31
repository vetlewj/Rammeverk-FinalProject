package scraper.html;

import java.util.ArrayList;

/**
 * Represents an HTML page. Contains a list of the top HTML elements in the page. These top elements will then
 * hold their child elements resulting in a tree-like structure.
 */
public class HtmlPage {
    /**
     * Represents the top HTML elements on the page in a list.
     */
    private ArrayList<HtmlElement> topElements;
}
