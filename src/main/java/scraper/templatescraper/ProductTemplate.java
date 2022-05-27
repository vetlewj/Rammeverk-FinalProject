package scraper.templatescraper;

import scraper.templatescraper.TemplateScraper;

public abstract class ProductTemplate extends TemplateScraper {

    public String getName() {
        // TODO: Missing implementation
        return null;
    }

    public float getPrice() {
        // TODO: Missing implementation
        return 0;
    }

    public String getDescription() {
        // TODO: Missing implementation
        return null;
    }

    public String getImage() {
        // TODO: Missing implementation
        return null;
    }

    public String getManufacturer() {
        // TODO: Missing implementation
        return null;
    }

    public String getCategory() {
        // TODO: Missing implementation
        return null;
    }

    public static ProductTemplate buildTemplate(ProductTemplate template) {
        return template;
    }
}
