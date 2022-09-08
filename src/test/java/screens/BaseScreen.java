package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class BaseScreen extends Screen {

    protected BaseScreen (By locator, String screenName) {
        super(locator, screenName);
        ILabel screen = getElementFactory().getLabel(locator, screenName);
        AqualityServices.getConditionalWait().waitFor(driver -> screen.state().isExist());
    }

}
