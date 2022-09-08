package screens;

import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import tools.constants.AdditionalAttributes;
import tools.utils.ScreenUtils;
import tools.utils.ViewUtils;
import tools.utils.supportModels.Bound;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductRibbonScreen extends BaseScreen {
    private static final By RIBBON_CONTAINER_BY = By.id("com.zdv.secretcloset:id/recycle");
    private static final String BANNERS_CONTAINER_XPATH = "//android.widget.RelativeLayout[@resource-id = 'com.zdv.secretcloset:id/rlBanner']";
    private static final String BANNERS_BRAND_NAME_XPATH = "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvBrand']";
    private static final String BANNERS_ORIGINAL_PRICE_XPATH = "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvSumm']";
    private static final String BANNERS_DISCOUNT_PERCENT_XPATH = "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvDiscount']";
    private static final String BANNERS_FINAL_PRICE_XPATH = "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvPrice']";
    private static final String BANNER_BRAND_LABEL_XPATH = "//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvBrand' and @text = '%s']";


    private static Dimension bannerDimension;

    public ProductRibbonScreen() {
        super(RIBBON_CONTAINER_BY,"Product ribbon screen");
    }

    public ProductScreen tapOnBanner(Product product) {
        getElementFactory().getLabel(
                By.xpath(String.format(BANNER_BRAND_LABEL_XPATH, product.getBrand())), "Banner brand label")
                .click();
        return new ProductScreen();
    }

    public Product getFirstProductWithDiscount() {
        List<ILabel> bannersWithDiscount = getVisibleBanners()
            .stream()
            .filter(banner -> getProductForBanner(banner).hasDiscount()).toList();
        ILabel firstBannerWithDiscount = bannersWithDiscount
                .stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Screen doesn't contain products with discount"));
        return getProductForBanner(firstBannerWithDiscount);
    }

    private Dimension getBannerDimension() {
        if (bannerDimension == null) {
            ILabel banner = getElementFactory().getLabel(By.xpath(BANNERS_CONTAINER_XPATH), "Banner");
            bannerDimension = Bound.getDimension(banner.getAttribute(AdditionalAttributes.BOUNDS.toString()));
        }
        return bannerDimension;
    }

    private List<ILabel> getVisibleBanners() {
        return getBanners()
                .stream()
                .filter(banner -> ScreenUtils.isFullViewOnScreen(banner, getBannerDimension()))
                .toList();
    }

    private List<ILabel> getBanners() {
        return getElementFactory().findElements(By.xpath(BANNERS_CONTAINER_XPATH), ElementType.LABEL);
    }

    private Product getProductForBanner(ILabel banner) {
        Product product = new Product();
        ILabel brandLabel = banner.findChildElement(By.xpath(BANNERS_BRAND_NAME_XPATH), ElementType.LABEL);
        product.setBrand(brandLabel.getText());

        ILabel originalPriceLabel = banner.findChildElement(By.xpath(BANNERS_ORIGINAL_PRICE_XPATH), ElementType.LABEL);
        product.setOriginalPrice(originalPriceLabel.getText());

        ILabel finalPriceLabel = banner.findChildElement(By.xpath(BANNERS_FINAL_PRICE_XPATH), ElementType.LABEL);
        product.setFinalPrice(finalPriceLabel.getText());

        if (ViewUtils.isChildElementExist(banner, By.xpath(BANNERS_DISCOUNT_PERCENT_XPATH))) {
            ILabel discountPercentLabel = banner.findChildElement(By.xpath(BANNERS_DISCOUNT_PERCENT_XPATH), ElementType.LABEL);
            product.setDiscount(discountPercentLabel.getText());
        }
        return product;
    }

}
