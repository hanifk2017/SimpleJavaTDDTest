package telford;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hanif on 18/01/17.
 */
public class CartTest {

    private static final String APPLE = "Apple";
    private static final String ORANGE = "Orange";
    private static final String BANANAS = "Bananas";

    private Cart cart;

    @Before
    public void before(){

        cart = new Cart();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotalWithNullProductListToCart(){

       cart.calculateTotal(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotalWithInvalidProductListToCart(){

        cart.calculateTotal(Arrays.asList(BANANAS));
    }

    @Test
    public void testTotalWithOneAppleProductToCart(){

        Assert.assertEquals(Double.valueOf(0.60),cart.calculateTotal(Arrays.asList(APPLE)));
    }

    @Test
    public void testTotalWithTwoApplesProductsToCart(){

        Assert.assertEquals(Double.valueOf(1.20),cart.calculateTotal(Arrays.asList(APPLE,APPLE)));
    }

    @Test
    public void testTotalWithOneAppleAndTwoOrangesProductsToCart(){

        Assert.assertEquals(Double.valueOf(1.10),cart.calculateTotal(Arrays.asList(APPLE,ORANGE,ORANGE)));
    }

}
