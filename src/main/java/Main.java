import scraper.Scraper;
import scraper.exceptions.InvalidXPathException;
import scraper.exceptions.ScraperNotInitializedException;
import scraper.html.HtmlElement;
import scraper.templatescraper.ProductTemplate;
import scraper.templatescraper.templates.SnlArticleTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @hidden Class for demonstrating some selected scenarios.
 */
public class Main {
    /**
     * @hidden main method to demonstrate scenarios.
     */
    public static void main(String[] args) {

        // 1. Set up a webscraper for https://snl.no/Michelangelo and retrieve all h1 elements.
        System.out.println("==== Scenario 1 ====");
        Scraper scraper1 = Scraper.createScraperWithURL("https://snl.no/Michelangelo");
        ArrayList<HtmlElement> htmlElements1 = scraper1.getElementsByTag("h1");

        for (HtmlElement htmlElement : htmlElements1) {
            System.out.println(htmlElement.getText());
        }


        // 2. Set up a webscraper for an html called "Michelangelo.html" located in the root folder of the project, and retrieve all p elements in the file to an arraylist
        System.out.println("==== Scenario 2 ====");
        File fileToScrape2 = new File("src/main/resources/snlMichelangelo.html");
        Scraper scraper2 = Scraper.createScraperWithHtmlFile(fileToScrape2);
        ArrayList<HtmlElement> paragraphs2 = scraper2.getElementsByTag("p");

        for (HtmlElement htmlElement : paragraphs2) {
            System.out.println(htmlElement.getText());
        }


        // 3. Set up a webscraper for the html string: "<p>Michelangelo was the name of an Italian sculptor, painter, architect and poet. </p><p>It was also the name of one of the main characters of <a href='#' > Teenage Mutant NinjaTurtles</a>.</p>", retrieve the text from all the p tags and print out the results to the console
        System.out.println("==== Scenario 3 ====");
        Scraper scraper3 = Scraper.createScraperWithString("<p>Michelangelo was the name of an Italian sculptor, painter, architect and poet. </p><p>It was also the name of one of the main characters of <a href='#' > Teenage Mutant NinjaTurtles</a>.</p>");

        for (HtmlElement el : scraper3.getElementsByTag("p")) {
            System.out.println(el.toString());
        }

        Scraper pwrScraper = Scraper.createScraperWithURL("https://www.power.no/hvitevarer/klesvask/tilbehoer-til-vask-og-toerk/toerkestativ/beha-tsh80-skotoerkehylle/p-233294/");
        System.out.println(pwrScraper.getRawContent());

        // 5. Create a template for a webscraper made to scrape general facts about a country from factbox on articles about countries for snl.no.
        class CountryTemplate extends SnlArticleTemplate {

            HashMap<String, String> facts = new HashMap<>();

            public CountryTemplate(String url) {
                super(url);
            }

            public HashMap<String, String> getFacts() {
                try {
                    ArrayList<HtmlElement> factsKeys = getScraper().getElementsByXpath("//dt[@class=\"factbox__fact-term\"]");
                    ArrayList<HtmlElement> factsValues = getScraper().getElementsByXpath("//dd[@class=\"factbox__fact-description\"]");

                    for (int i = 0; i < factsKeys.size(); i++) {
                        facts.put(factsKeys.get(i).getText(), factsValues.get(i).getText());
                    }
                } catch (InvalidXPathException | ScraperNotInitializedException e) {
                    e.printStackTrace();
                }
                return facts;
            }
        }

        // 6. Get all the facts in the factbox on https://snl.no/Australia using the template created in scenario 5 and print them to the console.
        CountryTemplate australia = new CountryTemplate("https://snl.no/Australia");

        HashMap<String, String> australiaFacts = australia.getFacts();
        for (String fact : australiaFacts.keySet()) {
            System.out.println(fact + ": " + australiaFacts.get(fact));
        }

        // 7. Get writers and date the article was published and last updated for https://snl.no/sjakk from an already created template for articles on snl.no.
        SnlArticleTemplate article = new SnlArticleTemplate("https://snl.no/sjakk");

        System.out.println(article.getWriters());
        System.out.println(article.getDatePublished());
        System.out.println(article.getDateLastUpdated());

    }
}
