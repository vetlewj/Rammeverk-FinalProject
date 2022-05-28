package scraper.xpathparser;

import scraper.exceptions.InvalidXPathException;

import java.util.Arrays;

public class XpathParser {
    // Method that parses an xpath string into a string of CSS selector syntax
    public static String parseXPathToCssSelector(String xPath) throws InvalidXPathException {
        // How to .split() and keep the delimiters are based on this article:
        // https://www.baeldung.com/java-split-string-keep-delimiters
        String[] xPathSplit = xPath.split("(?=[@\\[\\]\\/=])|(?<=[@\\[\\]\\/=])");
        System.out.println(Arrays.toString(xPathSplit));
        String ancestor = "/";
        String attribute = "@";
        StringBuilder CSSSelectorString = new StringBuilder();
        for (int i = 0; i < xPathSplit.length; i++) {
            // if char at i is /
            if (xPathSplit[i].equals(ancestor)) {
                // if char at i+1 is /
                if (xPathSplit[i + 1].equals(ancestor)) {
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
            } else if (xPathSplit[i].equals(attribute)) {
                // attribute is similar for css selector and xpath, but css selector does not have the @ symbol

            } else {
                // if the character does not need to be replaced, just add it to the string
                CSSSelectorString.append(xPathSplit[i]);
            }
        }
        return CSSSelectorString.toString();
    }

}
