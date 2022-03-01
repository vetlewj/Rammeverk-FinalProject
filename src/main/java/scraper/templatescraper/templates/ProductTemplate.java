package scraper.templatescraper.templates;

public interface ProductTemplate  {

    default String getName() {
        return null;
    }

    default float getPrice() {
        return 0;
    }

}
