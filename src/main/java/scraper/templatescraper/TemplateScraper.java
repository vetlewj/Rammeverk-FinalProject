package scraper.templatescraper;

import scraper.Scraper;

import java.io.File;

public abstract class TemplateScraper {
    private enum SourceType {URL, FILE, STRING}
    private Scraper scraper;

    private void setSource(String source, SourceType sourceType) {
        if (sourceType == SourceType.URL){
            scraper = Scraper.buildScraperWithURL(source);
        }
        else if (sourceType == SourceType.STRING){
            scraper = Scraper.buildScraperWithString(source);
        }
    }
    private void setSource(File file){
        scraper = Scraper.buildScraperWithHtmlFile(file);
    }

    public void setSourceAsUrl(String url){
        setSource(url, SourceType.URL);
    }
    public void setSourceAsString(String htmlString){
        setSource(htmlString, SourceType.STRING);
    }
    public void setSourceAsFile(File file){
        setSource(file);
    }
    public Scraper getScraper(){
        return scraper;
    }
}
