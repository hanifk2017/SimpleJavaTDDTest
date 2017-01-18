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

    private static final String APPLE_OFFER = "AppleOffer";
    private static final String ORANGE_OFFER = "OrangeOffer";
    private static final String INVALID_OFFER = "InvalidOffer";


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

    @Test(expected = IllegalArgumentException.class)
    public void testTotalWithNullDiscountCodeToCart(){

        cart.calculateTotal(Arrays.asList(APPLE,ORANGE,ORANGE),null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotalWithInvalidDiscountCodeToCart(){

       cart.calculateTotal(Arrays.asList(APPLE,ORANGE,ORANGE),INVALID_OFFER);
    }

    @Test
    public void testApplyAppleDiscountOfferOnOneApple(){

        Assert.assertEquals(Double.valueOf(0.60),cart.calculateTotal(Arrays.asList(APPLE),APPLE_OFFER));
    }

    @Test
    public void testApplyAppleDiscountOfferOnTwoApples(){

        Assert.assertEquals(Double.valueOf(1.20),cart.calculateTotal(Arrays.asList(APPLE,APPLE),APPLE_OFFER));
    }

    @Test
    public void testApplyOrangeDiscountOfferOnOneOrange(){

        Assert.assertEquals(Double.valueOf(0.25),cart.calculateTotal(Arrays.asList(ORANGE),ORANGE_OFFER));
    }

    @Test
    public void testApplyOrangeDiscountOfferOnTwoOranges(){

        Assert.assertEquals(Double.valueOf(0.50),cart.calculateTotal(Arrays.asList(ORANGE,ORANGE),ORANGE_OFFER));
    }

    @Test
    public void testApplyOrangeDiscountOfferOnThreeOranges(){

        Assert.assertEquals(Double.valueOf(0.50),cart.calculateTotal(Arrays.asList(ORANGE,ORANGE,ORANGE),ORANGE_OFFER));
    }

    @Test
    public void testApplyOrangeDiscountOfferOnFourOranges(){

        Assert.assertEquals(Double.valueOf(0.75),cart.calculateTotal(Arrays.asList(ORANGE,ORANGE,ORANGE,ORANGE),ORANGE_OFFER));
    }

    @Test
    public void testApplyOrangeDiscountOfferOnFiveOranges(){

        Assert.assertEquals(Double.valueOf(1.00),cart.calculateTotal(Arrays.asList(ORANGE,ORANGE,ORANGE,ORANGE,ORANGE),ORANGE_OFFER));
    }

    @Test
    public void testApplyOrangeDiscountOfferOnSixOranges(){

        Assert.assertEquals(Double.valueOf(1.00),cart.calculateTotal(Arrays.asList(ORANGE,ORANGE,ORANGE,ORANGE,ORANGE,ORANGE),ORANGE_OFFER));
    }

}
