package scraper.templatescraper;

import scraper.templatescraper.TemplateScraper;

public abstract class ProductTemplate extends TemplateScraper {

    public String getName() {
        return null;
    }

    public float getPrice() {
        return 0;
    }

    public String getDescription() {
        return null;
    }

    public String getImage() {
        return null;
    }

    public String getManufacturer() {
        return null;
    }

    public String getCategory() {
        return null;
    }
}
