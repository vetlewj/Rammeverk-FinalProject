package scraper.templatescraper;

import java.io.File;

public interface TemplateScraper {
    String getName(String className, String HtmlTag);
    String getPrice(String className, String HtmlTag);
    void setSource(String source, int sourcetype);
    void setSource(File file);
}
