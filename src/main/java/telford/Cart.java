package telford;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by hanif on 18/01/17.
 */
public class Cart {

    private static final String APPLE_OFFER = "AppleOffer";
    private static final String ORANGE_OFFER = "OrangeOffer";

    private static final String ORANGE = "Orange";


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

    public Double calculateTotal(List<String> productIds, String offerCode) {


        if (offerCode == null || !(offerCode.equals(APPLE_OFFER) || offerCode.equals(ORANGE_OFFER))){
            throw new IllegalArgumentException("Unknown Discount Code");
        }

        double total = calculateTotal(productIds);

        if (offerCode.equals(ORANGE_OFFER)) {

            int noOfOranges = Collections.frequency(productIds,ORANGE);

            double discount = (noOfOranges / 3) * productCatalog.getProduct(ORANGE);

            total -= discount;
        }

        return total;
    }
}
