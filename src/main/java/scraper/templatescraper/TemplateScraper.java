package scraper.templatescraper;

import scraper.Scraper;

import java.io.File;

public abstract class TemplateScraper {
    public enum SourceType {URL, FILE, STRING}
    private Scraper scraper;

    public void setSource(String source, SourceType sourceType) {

    }
    public void setSource(File file){

    }
    public Scraper getScraper(){
        return scraper;
    }
}
