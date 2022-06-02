import scraper.Scraper;
import scraper.exceptions.InvalidXPathException;
import scraper.exceptions.ScraperNotInitializedException;
import scraper.html.HtmlElement;
import scraper.templatescraper.ProductTemplate;

import java.io.File;
import java.util.ArrayList;

/**
 * @hidden Class for demonstrating scenarios.
 */
public class Main {
    /**
     * @hidden main method to demonstrate scenarios.
     */
    public static void main(String[] args) {
        // 01
        System.out.println("==== Scenario 1 ====");
        Scraper scraper1 = Scraper.createScraperWithURL("https://snl.no/Michelangelo");
        ArrayList<HtmlElement> htmlElements1 = scraper1.getElementsByTag("h1");

        for (HtmlElement htmlElement : htmlElements1) {
            System.out.println(htmlElement.getText());
        }


        // 02
        System.out.println("==== Scenario 2 ====");
        File fileToScrape2 = new File("src/main/resources/snlMichelangelo.html");
        Scraper scraper2 = Scraper.createScraperWithHtmlFile(fileToScrape2);
        ArrayList<HtmlElement> paragraphs2 = scraper2.getElementsByTag("p");

        for (HtmlElement htmlElement : paragraphs2) {
            System.out.println(htmlElement.getText());
        }


        // 03
        System.out.println("==== Scenario 3 ====");
        Scraper scraper3 = Scraper.createScraperWithString("<p>Michelangelo was the name of an Italian sculptor, painter, architect and poet. </p><p>It was also the name of one of the main characters of <a href='#' > Teenage Mutant NinjaTurtles</a>.</p>");

        for (HtmlElement el : scraper3.getElementsByTag("p")) {
            System.out.println(el.toString());
        }
    }
}
