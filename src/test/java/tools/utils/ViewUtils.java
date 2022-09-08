package tools.utils;

import aquality.appium.mobile.elements.interfaces.IElement;
import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class ViewUtils {

    public static boolean isChildElementExist(IElement element, By by) {
        return !element.findChildElements(by, ILabel.class).isEmpty();
    }

}
