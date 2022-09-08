package screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Product;
import models.Seller;
import org.openqa.selenium.By;

public class ProductScreen extends BaseScreen {
    private static final By BUY_BUTTON_BY = By.id("com.zdv.secretcloset:id/rlBuyButton");
    private final ILabel productBrandLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemBrand"), "Product brand label");
    private final ILabel originalPriceLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemOriginalPrice"), "Original price label");
    private final ILabel discountLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemDiscount"), "Discount label");
    private final ILabel finalPriceLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemPrice"), "Final price label");
    private final ILabel sellerNameLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerName"), "seller name label");
    private final ILabel sellerResponseRateLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerRate"), "Seller rate label");
    private final ILabel sellerResponseTimeLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerTime"), "Seller response time label");
    private final ILabel sellerRatingLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerRating"), "Seller rating label");
    private final ILabel sellerCityLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller city label");
    private final ILabel sellerLikeCount = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/likeCount"), "Seller like count label");
    private final ILabel sellerAvatar = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/ivSellerAvatar"), "seller avatar");

    public ProductScreen() {
        super(BUY_BUTTON_BY, "Select city screen");
    }

    public Product getProductModel() {
        Product product = new Product();
        product.setBrand(productBrandLabel.getText());
        product.setDiscount(discountLabel.getText());
        product.setFinalPrice(finalPriceLabel.getText());
        product.setOriginalPrice(originalPriceLabel.getText());
        return product;
    }

    public Seller getSellerModel() {
        Seller seller = new Seller();
        seller.setName(sellerNameLabel.getText())
                .setRate(sellerResponseRateLabel.getText())
                .setTime(sellerResponseTimeLabel.getText())
                .setRating(sellerRatingLabel.getText())
                .setCity(sellerCityLabel.getText())
                .setLikes(sellerLikeCount.getText());
        return seller;
    }

    public SellerScreen clickOnSellerAvatar() {
        sellerAvatar.click();
        return new SellerScreen();
    }

}
