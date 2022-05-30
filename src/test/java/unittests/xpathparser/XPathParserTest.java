package unittests.xpathparser;

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