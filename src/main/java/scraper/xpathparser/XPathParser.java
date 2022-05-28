package scraper.xpathparser;

import scraper.exceptions.InvalidXPathException;

/**
 * This class is used to parse an XPath expression and to return the string in a different format such as CSS selector.
 * It currently supports the following XPath operators:
 * Descendant: //
 * Attribute: [@key=value]
 * Parent: /
 * Tagname: tagname
 *
 * @author Vetle Jahr
 * @version 1.0
 */
public class XPathParser {
    /**
     * Converts a XPath expression to a CSS selector.
     *
     * @param xPath XPath expression to convert
     * @return CSS selector expression as a string.
     * @throws InvalidXPathException if the XPath expression is invalid or if the XPath expression is not supported.
     */
    public static String convertXPathToCssSelector(String xPath) throws InvalidXPathException {
        // How to .split() and keep the delimiters are based on this article:
        // https://www.baeldung.com/java-split-string-keep-delimiters
        String[] xPathArray = xPath.split("(?=[@\\[\\]\\/=])|(?<=[@\\[\\]\\/=])");
        String parent = "/";
        String attribute = "@";
        StringBuilder CSSSelectorString = new StringBuilder();
        for (int i = 0; i < xPathArray.length; i++) {
            // if char at i is /
            if (xPathArray[i].equals(parent)) {
                // if char at i+1 is /
                if (xPathArray[i + 1].equals(parent)) {
                    // if // at start of string, do nothing but skip to next char
                    if (i == 0) {
                        i = i + 1;
                    }
                    // if // is not at the start of xpath, add a space
                    else {
                        CSSSelectorString.append(" ");
                    }
                }
                // if char at i+1 is not /, the operator is a single /, not //, meaning it is a parent
                else {
                    CSSSelectorString.append(" > ");
                }
            } else if (xPathArray[i].equals(attribute)) {
                // attribute is similar for css selector and xpath, but css selector does not have the @ symbol
                // therefore we refrain from adding the @ symbol to the css selector.
            } else {
                // if the character does not need to be replaced, just add it to the string
                CSSSelectorString.append(xPathArray[i]);
            }
        }
        return CSSSelectorString.toString();
    }

}
