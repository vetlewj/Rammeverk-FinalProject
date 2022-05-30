package scraper.templatescraper;

/**
 * @author Vetle Jahr
 * @version 1.0
 */
public abstract class ProductTemplate extends TemplateScraper {

    /**
     * Gets the name of the product.
     *
     * @return name of the product
     */
    public abstract String getName();

    /**
     * Gets the price of the product.
     *
     * @return price of the product
     */
    public abstract float getPrice();

    /**
     * Gets the description of the product.
     *
     * @return description of the product
     */
    public abstract String getDescription();

    /**
     * Gets the url to the image of the product.
     *
     * @return url to image of the product
     */
    public abstract String getImage();

    /**
     * Gets the manufacturer of the product
     *
     * @return manufacturer of the product
     */
    public abstract String getManufacturer();

    /**
     * Gets the category that the product belongs to.
     *
     * @return category that the product belongs to
     */
    public abstract String getCategory();

    /**
     * Creates a ProductTemplate object from a template. To be created with an anonymous class that is used as parameter
     *
     * @param template template to create ProductTemplate from.
     * @return ProductTemplate object created from template.
     */
    public static ProductTemplate buildTemplate(ProductTemplate template) {
        return template;
    }
}
