package telford;

import java.util.HashMap;

/**
 * Created by hanif on 18/01/17.
 */
public class ProductCatalog {

    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";

    private HashMap<String,Double> products = new HashMap<String, Double>();

    public ProductCatalog() {

        products.put(APPLE,0.6);
        products.put(ORANGE,0.25);

    }

    public int getNoOfproducts() {

        return products.size();
    }

    public Double getProduct(String productId) {

        return products.get(productId);
    }
}
