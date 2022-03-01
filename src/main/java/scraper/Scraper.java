package scraper;

import scraper.HTML.HtmlElement;
import scraper.templatescraper.TemplateScraper;

import java.io.File;
import java.util.ArrayList;

public class Scraper {
    private enum SourceType {URL, FILE, STRING, TEMPLATE}

    public Scraper() {
    }

    private Scraper(String source, SourceType sourceType) {

    }

    private Scraper(File f) {

    }

    public static Scraper buildScraperWithURL(String url) {
        return new Scraper(url, SourceType.URL);
    }

    public static Scraper buildScraperWithString(String htmlString) {
        return new Scraper(htmlString, SourceType.STRING);
    }

    public static Scraper buildScraperWithHtmlFile(File f) {
        return null;
    }

    public ArrayList<HtmlElement> getElementsFromTag(String htmlTag) {
        return null;
    }

    public ArrayList<HtmlElement> getElementsFromClass(String className){
        return null;
    }
    public ArrayList<HtmlElement> getElementsByXpath(String xPath){
        return null;
    }
    public HtmlElement getElementById(String id){
        return null;
    }
    public String getTitle(){
        return null;
    }
}
