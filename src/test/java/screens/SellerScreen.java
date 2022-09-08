package screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Seller;
import org.openqa.selenium.By;

public class SellerScreen extends BaseScreen {
    private static final By AVATAR_BY = By.id("com.zdv.secretcloset:id/ivSellerAvatar");
    private final ILabel sellerNameLabel = getElementFactory().getLabel(By.xpath("//android.view.ViewGroup[@resource-id = 'com.zdv.secretcloset:id/toolbar']//android.widget.TextView"), "Seller name label");
    private final ILabel sellerIdLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerID"), "Seller label");
    private final ILabel sellerRateLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerRate"), "Seller rate label");
    private final ILabel sellerSellerTimeLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerTime"), "Seller time label");
    private final ILabel sellerRatingLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerRating"), "Seller rating label");
    private final ILabel sellerLikesLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerLikes"), "Seller likes label");
    private final ILabel sellerSellsLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerSells"), "Seller sells label");
    private final ILabel sellerCityLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller city label");
    private final ILabel sellerMemberLabel = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerMember"), "Seller member label");

    public SellerScreen() {
        super(AVATAR_BY, "Seller screen");
    }

    public Seller getSeller() {
        Seller seller = new Seller();
        seller.setName(sellerNameLabel.getText())
                .setId(sellerIdLabel.getText())
                .setRate(sellerRateLabel.getText())
                .setTime(sellerSellerTimeLabel.getText())
                .setRating(sellerRatingLabel.getText())
                .setLikes(sellerLikesLabel.getText())
                .setSells(sellerSellsLabel.getText())
                .setCity(sellerCityLabel.getText())
                .setMember(sellerMemberLabel.getText());
        return seller;
    }
}
