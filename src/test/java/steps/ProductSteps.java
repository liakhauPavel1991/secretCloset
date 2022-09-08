package steps;

import models.Product;
import org.junit.jupiter.api.Assertions;
import screens.ProductRibbonScreen;
import screens.ProductScreen;

public class ProductSteps extends BaseStep {

    public static void verifyProductPriceWithDiscount() {
        Product firstItemWithDiscount = tapFirstItemWithDiscount();
        verifyThatProductPriceOnMainScreenAndProductScreenTheSame(firstItemWithDiscount);
        verifyDiscountCalculation(firstItemWithDiscount);
    }

    public static Product tapFirstItemWithDiscount() {
        ProductRibbonScreen ribbonScreen = new ProductRibbonScreen();
        Product productWithDiscount = ribbonScreen.getFirstProductWithDiscount();
        ProductScreen productScreen = ribbonScreen.tapOnBanner(productWithDiscount);
        Assertions.assertTrue(productScreen.state().isDisplayed(),
                "Product screen is opened");
        return productWithDiscount;
    }

    public static void verifyThatProductPriceOnMainScreenAndProductScreenTheSame(Product product) {
        ProductScreen productScreen = new ProductScreen();
        Assertions.assertEquals(product, productScreen.getProductModel(),
                String.format("Product from main screen %s, product from product screen %s", product, productScreen));
    }

    public static void verifyDiscountCalculation(Product product) {
        int fullPrice = product.getOriginalPrice();
        int discount = product.getDiscountPercentValue();
        int result = fullPrice - (int) Math.ceil((double) fullPrice * discount / 100);
        Assertions.assertEquals(product.getFinalPrice(), result,
                "discount calculation is correct");
    }
}
