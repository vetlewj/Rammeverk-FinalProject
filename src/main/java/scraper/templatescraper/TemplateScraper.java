package scraper.templatescraper;

import scraper.Scraper;

import java.io.File;

public abstract class TemplateScraper {
    private enum SourceType {URL, FILE, STRING}
    private Scraper scraper;

    private void setSource(String source, SourceType sourceType) {

    }
    private void setSource(File file){

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
