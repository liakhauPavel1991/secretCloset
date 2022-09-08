package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import org.openqa.selenium.By;
import screens.alerts.CityAlert;

public class MainScreen extends BaseScreen {
    private static final By TITLE_BY = By.id("com.zdv.secretcloset:id/tvTitle");
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

}
