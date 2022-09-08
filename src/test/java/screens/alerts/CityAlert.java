package screens.alerts;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public class CityAlert extends BaseAlert {
    public CityAlert() {
        super(id("android:id/content"));
    }

    @Override
    protected By getMessageLblLoc() {
        return id("android:id/message");
    }

    @Override
    protected By getOkBtnLoc() {
        return id("android:id/button1");
    }

    @Override
    protected By getDontShowAgainBtnLoc() {
        return id("android:id/button2");
    }
}
