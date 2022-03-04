# Getting started
The framework is divided into two layers; Scraper, a regular web scraper, and TemplateScraper, a set of classes and functions to create your own custom templates for scraping websites. 

## Setup
The framework can be downloaded from [Github](https://github.com/vetlewj/Rammeverk-FinalProject). Click on the green
button that says Code and you will get the option to clone the project in various ways. If you are not familiar with 
git, the easiest solution is to Download as ZIP. After downloading the ZIP, the next is to unpack the project in a 
designated location. Then you can open the folder with Visual Studio Code, IntelliJ or another editor. 

The classes and methods are currently not implemented yet as it is just the code primitives. Therefore nothing will 
happen if you try to use this framework yet. 

However, the solution can be compiled and built using gradle. 

## Scraper
Scraper is meant to be used as most other web scrapers available, and it requires some familiarity with HTML, XML or 
other similar languages. 

Scraper can be used to scrape HTML documents and get requested data.

### Examples

#### Set up a webscraper for https://snl.no/Michelangelo and retrieve all h1 elements.

```java
Scraper scraper1 = Scraper.buildScraperWithURL("https://snl.no/Michelangelo");
scraper1.getElementsFromTag("h1");
```

#### Set up a webscraper for an html called “Michelangelo.html” located in the root folder of the project, and retrieve alle p elements in the file to an arraylist
```java
File fileToScrape = new File("../Michelangelo.html");
Scraper scraper2 = Scraper.buildScraperWithHtmlFile(fileToScrape);
ArrayList<HtmlElement> paragraphs;

paragraphs = scraper2.getElementsFromTag("p");
```

## TemplateScraper
TemplateScraper is another layer of abstraction that is meant to make it easy to create Templates for scraping websites.

As of 04.03.22 there are two templates you can use when creating your own custom templates; ArticleTemplate and 
ProductTemplate. When you create your own templates to scrape articles or products, you can inherit from these classes 
and override the methods where you need a custom implementation. 

### Examples

#### Create a template for a webscraper made to scrape the name and price from products on power.no

```java
class PowerProductTemplate extends ProductTemplate {

    private String name;
    private float price;

    public String getName() {
        this.name = getScraper().getElementsByXpath("//div[@class=\"h2 bold my-spacer-none\"][1]").toString();
        return this.name;
    }

    public float getPrice() {
        this.price = Float.parseFloat(getScraper().getElementsFromTag("pwr-price").toString());
        return this.price;
    }
}
```