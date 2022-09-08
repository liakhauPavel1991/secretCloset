package screens.alerts;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class BaseAlert extends Screen {

    private final ILabel messageLbl;
    private final IButton okBtn;
    private final IButton dontShowAgainBtn;

    protected BaseAlert(By locator) {
        super(locator, "Alert");
        messageLbl = getElementFactory().getLabel(getMessageLblLoc(), "Message");
        okBtn = getElementFactory().getButton(getOkBtnLoc(), "OK");
        dontShowAgainBtn = getElementFactory().getButton(getDontShowAgainBtnLoc(), "Don't Show Again");
    }

    protected abstract By getMessageLblLoc();

    protected abstract By getOkBtnLoc();

    protected abstract By getDontShowAgainBtnLoc();

    public String getMessage() {
        return messageLbl.getText();
    }

    public void tapOk() {
        okBtn.click();
    }

    public void tapDontShowAgain() {
        dontShowAgainBtn.click();
    }
}