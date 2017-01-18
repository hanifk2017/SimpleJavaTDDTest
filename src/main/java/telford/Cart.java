package telford;

import java.util.List;

/**
 * Created by hanif on 18/01/17.
 */
public class Cart {

    private ProductCatalog productCatalog = new ProductCatalog();


    public Double calculateTotal(List<String> productIds) {

        double total = 0.0;

        if (productIds == null || productIds.size() == 0){
            throw new IllegalArgumentException("Empty Product List");
        }

        for(String productId:productIds){

            Double product = productCatalog.getProduct(productId);
            if (product == null){
                throw new IllegalArgumentException("Unknown Product in List");
            }

            total += product;
        }

        return total;
    }
}
