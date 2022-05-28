package unittests;

import org.junit.jupiter.api.Test;
import scraper.exceptions.InvalidXPathException;
import scraper.xpathparser.XPathParser;

public class XPathParserTest {

    @Test
    void parseXPathToCssSelector() throws InvalidXPathException {
        String xPath = "//div[@class='product-info']/h1";
        String cssSelector = XPathParser.convertXPathToCssSelector(xPath);
        assert cssSelector.equals("div[class='product-info'] > h1");
    }

}
// Alternate implementation of XpathToCssSelector method
//                    // if tagname
//                    else if (Pattern.matches("[a-zA-Z]", xPathSplit[i+2])) {
//                        // TODO: implement
//                    }
//                    // if parent
//                    else if(xPathSplit[i+2].equals(parent)) {
//                        // TODO: implement
//                    }
//                    // if an attribute
//                    else if (xPathSplit[i + 2].equals(attribute)) {
//                        String key = xPathSplit[i + 3];
//                        if (xPathSplit[i + 4].equals(attributeEquals)) {
//                            String value = xPathSplit[i + 5];
//                            // elements = elements.select(parent + key + attribute + value);
//                            i = i + 5;
//                        } else {
//                            throw new InvalidXPathException("Invalid xpath: " + xPath + "Attribute value not found " +
//                                                            "for key: " + key);
//                        }
//                    }
//
//
//                    else if(xPathSplit[i+1].equals(attribute)) {
//                    String key = xPathSplit[i+2];
//                    if(xPathSplit[i+3].equals(attributeEquals)) {
//                        String value = xPathSplit[i+4];
//                        // elements = elements.select(parent + key + attribute + value);
//                        i = i + 4;
//                    } else {
//                        throw new InvalidXPathException("Invalid xpath: " + xPath + "Attribute value not found " +
//                                                        "for key: " + key);
//                    }
//                }

