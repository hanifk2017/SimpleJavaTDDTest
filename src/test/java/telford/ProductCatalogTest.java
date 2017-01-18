package telford;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hanif on 18/01/17.
 */
public class ProductCatalogTest {

    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";
    private static final String BANANAS = "Bananas";

    private ProductCatalog productCatalog;

    @Before
    public void before(){

        productCatalog = new ProductCatalog();
    }

    @Test
    public void testOnlyTwoProductsInProductCatalog(){

        Assert.assertEquals(productCatalog.getNoOfproducts(),2);
    }

    @Test
    public void testApplesAndOrangesInProductCatalog(){

        Assert.assertNotNull(productCatalog.getProduct(APPLE));
        Assert.assertNotNull(productCatalog.getProduct(ORANGE));

    }

    @Test
    public void testProductsOtherThanApplesAndOrangesNotInProductCatalog(){

        Assert.assertNull(productCatalog.getProduct(null));
        Assert.assertNull(productCatalog.getProduct(BANANAS));

    }

    @Test
    public void testProductPricesAreCorrectInProductCatalog(){

        Assert.assertEquals(Double.valueOf(0.6), productCatalog.getProduct(APPLE));
        Assert.assertEquals(Double.valueOf(0.25),productCatalog.getProduct(ORANGE));

    }
}
