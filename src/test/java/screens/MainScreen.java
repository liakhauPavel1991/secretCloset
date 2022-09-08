package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Product;
import org.openqa.selenium.By;
import screens.alerts.CityAlert;
import java.util.LinkedList;
import java.util.List;

public class MainScreen extends BaseScreen {
    private static final By TITLE_BY = By.id("com.zdv.secretcloset:id/tvTitle");
    private static final String BANNERS_CONTAINER_XPATH = "(//android.widget.RelativeLayout[@resource-id = 'com.zdv.secretcloset:id/rlBanner'])";
    private static final String BANNER_NUMBER = "[%d]";
    private static final String BANNERS_BRAND_NAME_XPATH = BANNERS_CONTAINER_XPATH + BANNER_NUMBER + "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvBrand']";
    private static final String BANNERS_ORIGINAL_PRICE_XPATH = BANNERS_CONTAINER_XPATH + BANNER_NUMBER + "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvSumm']";
    private static final String BANNERS_DISCOUNT_PERCENT_XPATH = BANNERS_CONTAINER_XPATH + BANNER_NUMBER + "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvDiscount']";
    private static final String BANNERS_FINAL_PRICE_XPATH = BANNERS_CONTAINER_XPATH + BANNER_NUMBER + "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvPrice']";
    private static final String BANNER_BRAND_LABEL_XPATH = "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvBrand' and @text = '%s']";
    private final IButton cityButton = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "City button");

    public MainScreen() {
        super(TITLE_BY, "Main screen");
    }

    public CityAlert tapCityButton() {
        cityButton.click();
        return new CityAlert();
    }

    public String getCityButtonText() {
        return cityButton.getText();
    }

    public void waitUntilCityButtonContains(String cityName) {
        AqualityServices.getConditionalWait().waitFor(driver -> cityButton.getText().equals(cityName));
    }

    public List<Product> getProductsFromMainScreen() {
        List <ILabel> banners = getElementFactory().findElements(By.xpath(BANNERS_CONTAINER_XPATH), ElementType.LABEL);
        List<Product> products = new LinkedList<>();

        for (int i = 1; i < banners.size(); i++) {
            Product product = new Product();

            ILabel brandLabel = getElementFactory()
                    .getLabel(By.xpath(String.format(BANNERS_BRAND_NAME_XPATH, i)), "Banner brand label");
            product.setBrand(brandLabel.getText());

            ILabel finalPriceLabel = getElementFactory()
                    .getLabel(By.xpath(String.format(BANNERS_FINAL_PRICE_XPATH, i)), "Banner final price label");
            product.setFinalPrice(finalPriceLabel.getText());

            ILabel originalPriceLabel = getElementFactory()
                    .getLabel(By.xpath(String.format(BANNERS_ORIGINAL_PRICE_XPATH, i)), "Banner discount amount label");
            product.setOriginalPrice(originalPriceLabel.getText());

            if (!getElementFactory().findElements(
                    By.xpath(String.format(BANNERS_DISCOUNT_PERCENT_XPATH, i)), ElementType.LABEL).isEmpty())
            {
                ILabel discountPercentLabel = getElementFactory()
                        .getLabel(By.xpath(String.format(BANNERS_DISCOUNT_PERCENT_XPATH, i)), "Banner discount percent label");
                product.setDiscount(discountPercentLabel.getText());
            }
            products.add(product);
        }
        return products;
    }

    public ProductScreen clickOnBanner(String name) {
        getElementFactory().getLabel(By.xpath(String.format(BANNER_BRAND_LABEL_XPATH, name)), "Banner brand label").click();
        return new ProductScreen();
    }
}
