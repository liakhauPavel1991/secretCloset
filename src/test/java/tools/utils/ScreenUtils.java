package tools.utils;

import aquality.appium.mobile.elements.interfaces.IElement;
import org.openqa.selenium.Dimension;
import tools.constants.AdditionalAttributes;
import tools.utils.supportModels.Bound;

public class ScreenUtils {

    public static boolean isFullViewOnScreen(IElement element, Dimension dimension) {
        String bounds = element.getAttribute(AdditionalAttributes.BOUNDS.toString());
        return Bound.getDimension(bounds).equals(dimension);
    }
}
