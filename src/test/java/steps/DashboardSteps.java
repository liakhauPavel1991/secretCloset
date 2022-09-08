package steps;

import models.Product;
import models.Seller;
import org.junit.jupiter.api.Assertions;
import screens.ProductScreen;
import screens.MainScreen;
import screens.SelectCityScreen;
import screens.SellerScreen;
import screens.alerts.CityAlert;
import java.util.NoSuchElementException;

public class DashboardSteps extends BaseStep {

    public static void selectRandomCity() {
        tapOnCityOnMainPage();
        String randomCity = typeRandomCity();
        tapOnCityInList(randomCity);
    }

    public static void tapOnCityOnMainPage() {
        MainScreen mainPage = new MainScreen();
        CityAlert cityAlert = mainPage.tapCityButton();
        cityAlert.tapOk();
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        Assertions.assertTrue(selectCityScreen.state().isDisplayed(),
                "The city selection screen is open");
    }

    public static String typeRandomCity() {
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        String randomCityName = selectCityScreen.getRandomCityNameFromList();
        selectCityScreen.typeInCityTextBox(randomCityName);
        Assertions.assertEquals(randomCityName, selectCityScreen.getTextFromCityTextBox(),
                "Search city textBox shows entered value");
        return randomCityName;
    }

    public static void tapOnCityInList(String city) {
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        MainScreen mainScreen = selectCityScreen.tapOnCity(city);
        mainScreen.waitUntilCityButtonContains(city);
        Assertions.assertTrue(mainScreen.state().isDisplayed(),
                "After tap on city main screen");
        Assertions.assertEquals(city, mainScreen.getCityButtonText(),
                "Chosen city is displayed on main screen");
    }

    public static void verifyProductPriceWithDiscount() {
        Product firstItemWithDiscount = tapFirstItemWithDiscount();
        verifyThatProductPriceOnMainScreenAndProductScreenTheSame(firstItemWithDiscount);
        verifyDiscountCalculation(firstItemWithDiscount);
    }

    public static Product tapFirstItemWithDiscount() {
        MainScreen mainScreen = new MainScreen();
        Product firstItemWithDiscount = mainScreen.getProductsFromMainScreen()
                .stream()
                .filter(Product::hasDiscount)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No Items with discount"));
        ProductScreen productScreen = mainScreen.clickOnBanner(firstItemWithDiscount.getBrand());
        Assertions.assertTrue(productScreen.state().isDisplayed(),
                "Product screen is opened");
        return firstItemWithDiscount;
    }

    public static void verifyThatProductPriceOnMainScreenAndProductScreenTheSame(Product product) {
        ProductScreen productScreen = new ProductScreen();
        Assertions.assertEquals(product.getBrand(), productScreen.getProductBrandName(),
                "Brand on product screen the same as on main page");
        Assertions.assertEquals(product.getOriginalPrice(), productScreen.getOriginalPriseValue(),
                "Original Prise on product screen the same as on main page");
        Assertions.assertEquals(product.getOriginalPriceCurrency(), productScreen.getOriginalPriceCurrency(),
                "Original Price Currency on product screen the same as on main page");
        Assertions.assertEquals(product.getFinalPrice(), productScreen.getFinalPriseValue(),
                "Fina lPrise Value on product screen the same as on main page");
        Assertions.assertEquals(product.getFinalPriceCurrency(), productScreen.getFinalPriceCurrency(),
                "Final Price Currency on product screen the same as on main page");
        Assertions.assertEquals(product.getDiscountPercentValue(), productScreen.getDiscountLabelValue(),
                "Discount Value on product screen the same as on main page");
        Assertions.assertEquals(product.getDiscountPercentString(), productScreen.getDiscountText(),
                "Discount on product screen the same as on main page");
    }

    public static void verifyDiscountCalculation(Product product) {
        int fullPrice = product.getOriginalPrice();
        int discount = product.getDiscountPercentValue();
        int result = fullPrice - (int) Math.ceil((double) fullPrice * discount / 100);
        Assertions.assertEquals(product.getFinalPrice(), result,
                "discount calculation is correct");
    }

    public static void verifySellerInfo() {
        ProductScreen productScreen = new ProductScreen();
        Seller sellerOnProductScreen = productScreen.getSellerFromProductScreen();
        SellerScreen sellerScreen = clickOnSeller();
        Seller sellerOnSellerScreen = sellerScreen.getSeller();
        Assertions.assertEquals(sellerOnProductScreen, sellerOnSellerScreen, "Seller info on product screen and seller screen are the same");
    }

    public static SellerScreen clickOnSeller() {
        ProductScreen productScreen = new ProductScreen();
        SellerScreen sellerScreen = productScreen.clickOnSellerAvatar();
        Assertions.assertTrue(sellerScreen.state().isDisplayed(),
                "Seller screen is opened");
        return sellerScreen;
    }


}
