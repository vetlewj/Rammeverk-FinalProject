package scraper.html;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import scraper.exceptions.InvalidXPathException;
import scraper.xpathparser.XPathParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an HTML Tag.
 * A wrapper for the Jsoup Element class.
 *
 * @author Vetle Jahr
 * @version 1.0
 */
public class HtmlElement {
    /**
     * Internal Jsoup Element
     */
    private Element jsoupInternalElement;
    /**
     * Name of the tag
     */
    private String tagName;
    /**
     * HtmlElement's attributes
     */
    private Map<String, String> attributes = new HashMap<>();
    /**
     * Represents the child HTML elements. Only contains the direct children.
     */
    private ArrayList<HtmlElement> childElements = new ArrayList<>();
    /**
     * String representation of the content in the tag.
     */
    private String content;

    /**
     * Creates a new HtmlElement with no properties set.
     */
    public HtmlElement() {
    }

    /**
     * Creates a new HtmlElement and sets the tag-name and attributes.
     *
     * @param tagName    Tag-name of the new HtmlElement.
     * @param attributes Attributes of the new HtmlElement.
     */
    public HtmlElement(String tagName, HashMap<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    /**
     * Creates a new HtmlElement from a JSoup Element.
     *
     * @param element JSoup Element to create HtmlElement from.
     * @return HtmlElement created from JSoup Element.
     */
    public static HtmlElement ElementToHtmlElement(Element element) {
        if (element == null) {
            return null;
        }
        HtmlElement htmlElement = new HtmlElement();
        htmlElement.tagName = element.tagName();
        for (Attribute attribute : element.attributes()){
            htmlElement.attributes.put(attribute.getKey(), attribute.getValue());
        }
        htmlElement.content = element.text();
        htmlElement.jsoupInternalElement = element;

        for (Element childElement : element.children()) {
            htmlElement.childElements.add(ElementToHtmlElement(childElement));
        }
        return htmlElement;
    }

    /**
     * Finds a child-element from a given Xpath
     *
     * @param XPathString Xpath of the HtmlElement to find.
     * @return HtmlElement found.
     */
    public HtmlElement getChildByXPath(String XPathString) {
        try {
            return ElementToHtmlElement(jsoupInternalElement.select(XPathParser.convertXPathToCssSelector(XPathString)).first());
        } catch (InvalidXPathException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the Name of the tag of the HtmlElement.
     *
     * @return Name of HtmlElement.
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Set Tag-name of the HtmlElement.
     *
     * @param tagName Name of the tag.
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Get the attributes of the HtmlElement.
     *
     * @return Attributes of the HtmlElement.
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Set attributes of the HtmlElement.
     *
     * @param attributes HashMap of attributes to set for HtmlElement.
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    /**
     * Get the child elements of the HtmlElement.
     *
     * @return ArrayList of child elements.
     */
    public ArrayList<HtmlElement> getChildElements() {
        return childElements;
    }

    /**
     * Set ChildElements of HtmlElement
     *
     * @param childElements ArrayList of child elements to set.
     */
    public void setChildElements(ArrayList<HtmlElement> childElements) {
        this.childElements = childElements;
    }

    /**
     * Get text Content of the HtmlElement.
     *
     * @return text content of the HtmlElement
     */
    public String getStringContentOfCurrentElement() {
        return content;
    }

    /**
     * Set the content of the HtmlElement.
     *
     * @param content Content of the HtmlElement to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the String content of current element and all child elements.
     *
     * @return String content of current element and all child elements.
     */
    public String getStringContentOfCurrentElementAndChildren() {
        StringBuilder sb = new StringBuilder();
        for (HtmlElement element : childElements) {
            sb.append(element.getStringContentOfCurrentElementAndChildren());
        }
        return sb.toString();
    }


    /**
     * Gets the HtmlElement as a string in the format of a html tag:
     * <code>&#60;tagname attribute1=x&#62;content&#60;childelements&#62;&#60;/tagname&#62;</code>
     * @return String representation of the HtmlElement.
     */
    @Override
    public String toString() {
        StringBuilder attributesString = new StringBuilder();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            attributesString.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        StringBuilder childElementsString = new StringBuilder();
        for (HtmlElement element : childElements) {
            childElementsString.append(element.toString());
        }
        return "<" + tagName + "" + attributesString + ">" + content + childElementsString + "</" + tagName + ">";
    }

    /**
     * Gets the value of a specified attribute.
     * @param attribute Attribute to get value of.
     * @return Value of the attribute.
     */
    public String getAttributeValue(String attribute) {
        return attributes.get(attribute);
    }

    /**
     * Gets the text content of the HtmlElement.
     * @return Text content of the HtmlElement.
     */
    public String getText() {
        return content;
    }

    /**
     * Gets a list of HtmlElements from a specified class name. The class name is the name of the class attribute.
     *
     * @param className Class name of the elements to get.
     * @return ArrayList of HtmlElements with the specified class name.
     */
    public ArrayList<HtmlElement> getElementsFromClass(String className) {
        Elements elements = jsoupInternalElement.getElementsByClass(className);
        ArrayList<HtmlElement> htmlElements = new ArrayList<>();
        for (Element element : elements) {
            htmlElements.add(ElementToHtmlElement(element));
        }
        return htmlElements;
    }

}
