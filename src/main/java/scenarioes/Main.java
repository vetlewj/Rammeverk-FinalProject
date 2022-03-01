package scenarioes;

import scraper.templatescraper.templates.ArticleTemplate;
import scraper.HTML.HtmlElement;
import scraper.Scraper;
import scraper.templatescraper.TemplateScraper;

import java.io.File;
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


// 04.01
        class ProductTemplate extends TemplateScraper {

            private String name;
            private float price;

            public String getName() {
                this.name = getScraper().getElement("//div[@class=\"h2 bold my-spacer-none\"][1]").toString();
                return this.name;
            }

            public float getPrice() {
                this.price = getScraper().getElement("//pwr-price").toString();
                return this.price;
            }
        }

// 04.02
        // TemplateScraper product = TemplateScraper.create({{"name", "//div[@class=\"h2 bold my - spacer - none\"][1]"}, {"price", "//pwr-price"});


        //05
        class CountryTemplate extends TemplateScraper {

            HashMap<String, String> facts = new HashMap<>();

            public HashMap<String, String> getFacts() {
                ArrayList<HtmlElement> factsArray = getScraper().getElements("//[@class="factbox__facts"]");
                for (HtmlElement el : factsArray) {
                    factsH.put(el.getChild("//[@class="factbox__fact - term"]").toString, el.getChild("//[@class="factbox__fact - description"]").toString())
                }
            }
        }


// 06
        CountryTemplate australia = new ConutryTemplate("https://snl.no/Australia");

        HashMap<String, String> australiaFacts = new Hashmap<>();
        australiaFacts = australia.getFacts();
        for (String fact : australiaFacts.keySet()) {
            System.out.println(fact + ": " + australiaFacts.get(fact));
        }


// 07
        ArticleTemplate article = new ArticleTemplate();
        article.setSource("https://snl.no/onomatopoetikon");

        article.getWriters();
        article.getDatePublished();
        article.getDateUpdated();


// 07
        ArticleTemplate article = new ArticleTemplate();
        article.setSource("https://snl.no/Australia")

        article.articleToJson();


    }
    }
