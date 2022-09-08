package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools.utils.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;

public class SelectCityScreen extends BaseScreen {
    private static final By SEARCH_TEXT_BOX_BY = By.id("com.zdv.secretcloset:id/etSearchTest");
    private static final By CITIES_LIST_BY = By.xpath("//android.widget.TextView[@resource-id = 'com.zdv.secretcloset:id/tvCityItemName']");
    private static final String CITY_XPATH = "//android.widget.TextView[@text = '%s']";
    private final ITextBox citiesTextBox = getElementFactory().getTextBox(By.id("com.zdv.secretcloset:id/etSearchTest"), "Select Country");

    public SelectCityScreen() {
        super(SEARCH_TEXT_BOX_BY, "Select city screen");
    }

    public void typeInCityTextBox(String countryName) {
        citiesTextBox.type(countryName);
    }

    public void clearCityTextBox() {
        citiesTextBox.clear();
    }

    public String getTextFromCityTextBox() {
        return citiesTextBox.getText();
    }

    private List<ILabel> getCitiesList() {
        AqualityServices.getConditionalWait().waitFor(ExpectedConditions.elementToBeClickable(CITIES_LIST_BY));
        return getElementFactory().findElements(CITIES_LIST_BY, ElementType.LABEL);
    }

    public List<String> getCitiesListAsString() {
        return getCitiesList()
                .stream()
                .map(ILabel::getText)
                .collect(Collectors.toList());
    }

    public String getRandomCityNameFromList() {
        return getRandomCityFromList().getText();
    }

    private ILabel getRandomCityFromList() {
        return RandomUtils.getRandomItemFromList(getCitiesList());
    }

    public MainScreen tapOnCity(String cityName) {
        getElementFactory().getLabel(By.xpath(String.format(CITY_XPATH, cityName)), "City label").click();
        return new MainScreen();
    }


}
