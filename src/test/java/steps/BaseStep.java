package steps;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.screens.IScreen;


public abstract class BaseStep {

    protected static <T extends IScreen> T getScreen(Class<T> clazz) {
        return AqualityServices.getScreenFactory().getScreen(clazz);
    }
}
