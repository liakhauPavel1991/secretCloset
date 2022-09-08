package steps;

import org.junit.jupiter.api.Assertions;
import screens.MainScreen;
import screens.SelectCityScreen;
import screens.alerts.CityAlert;

public class MainScreenSteps extends BaseStep {

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

}
