package scenarios;

import scraper.templatescraper.TemplateScraper;
import scraper.templatescraper.ArticleTemplate;
import scraper.html.HtmlElement;
import scraper.Scraper;
import scraper.templatescraper.ProductTemplate;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @hidden Class for demonstrating scenarioes.
 */
public class Main {
    public static void main(String[] args) {

        // 01
        Scraper scraper1 = Scraper.buildScraperWithURL("https://snl.no/Michelangelo");
        scraper1.getElementsFromTag("h1");


        // 02
        File fileToScrape = new File("../Michelangelo.html");
        Scraper scraper2 = Scraper.buildScraperWithHtmlFile(fileToScrape);
        ArrayList<HtmlElement> paragraphs;

        paragraphs = scraper2.getElementsFromTag("p");


        // 03
        Scraper scraper3 = Scraper.buildScraperWithString("<p>Michelangelo was the name of an Italian sculptor, painter, architect and poet. </p><p>It was also the name of one of the main characters of <a href='#' > Teenage Mutant NinjaTurtles</a>.</p>");

        for (HtmlElement el : scraper3.getElementsFromTag("p")) {
            System.out.println(el.toString());
        }


        // 04
        class PowerProductTemplate extends ProductTemplate {

            private String name;
            private float price;

            public String getName() {
                this.name = getScraper().getElementsByXpath("//div[@class=\"h2 bold my-spacer-none\"][1]").toString();
                return this.name;
            }

            public float getPrice() {
                this.price = Float.parseFloat(getScraper().getElementsByXpath("//pwr-price").toString());
                return this.price;
            }
        }


        //05
        class CountryTemplate extends ArticleTemplate {

            HashMap<String, String> facts = new HashMap<>();

            public HashMap<String, String> getFacts() {
                ArrayList<HtmlElement> factsArray = getScraper().getElementsByXpath("//[@class=\"factbox__facts\"]");
                for (HtmlElement el : factsArray) {
                    facts.put(el.getChildByXPath("//[@class=\"factbox__fact-term\"]").toString(), el.getChildByXPath("//[@class=\"factbox__fact - description\"]").toString());
                }
                return facts;
            }

            @Override
            public String getHeader() {
                return null;
            }

            @Override
            public String getIntroduction() {
                return null;
            }

            @Override
            public ArrayList<HtmlElement> getParagraphs() {
                return null;
            }

            @Override
            public HashMap<String, String> getTextContentWithHeaders() {
                return null;
            }

            @Override
            public ArrayList<String> getWriters() {
                return null;
            }

            @Override
            public LocalDate getDatePublished() {
                return null;
            }

            @Override
            public LocalDateTime getDateTimePublished() {
                return null;
            }

            @Override
            public LocalDate getDateLastUpdated() {
                return null;
            }

            @Override
            public LocalDateTime getDateTimeLastUpdated() {
                return null;
            }

            @Override
            public File articleToJson() {
                return null;
            }
        }


        // 06
        CountryTemplate australia = new CountryTemplate();
        australia.setSource("https://snl.no/Australia", TemplateScraper.SourceType.URL);

        HashMap<String, String> australiaFacts;
        australiaFacts = australia.getFacts();
        for (String fact : australiaFacts.keySet()) {
            System.out.println(fact + ": " + australiaFacts.get(fact));
        }


        // 07
        CountryTemplate article = new CountryTemplate();
        article.setSource("https://snl.no/onomatopoetikon", TemplateScraper.SourceType.URL);

        article.getWriters();
        article.getDatePublished();
        article.getDateLastUpdated();


        // 08
        CountryTemplate article08 = new CountryTemplate();
        article.setSource("https://snl.no/Australia", TemplateScraper.SourceType.URL);

        article.articleToJson();
    }
}
