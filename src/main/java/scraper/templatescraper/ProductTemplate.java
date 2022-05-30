package scraper.templatescraper;

import scraper.templatescraper.TemplateScraper;

/**
 * @author Vetle Jahr
 * @version 1.0
 */
public abstract class ProductTemplate extends TemplateScraper {

    public abstract String getName();

    public abstract float getPrice();

    public abstract String getDescription();

    public abstract String getImage();

    public abstract String getManufacturer();

    public abstract String getCategory();

    public static ProductTemplate buildTemplate(ProductTemplate template) {
        return template;
    }
}
