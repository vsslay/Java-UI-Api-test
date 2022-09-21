package pages.alerts_frames_windows_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public final By alertButton = By.id("alertButton");
    public final By timerAlertButton = By.id("timerAlertButton");
    public final By confirmButton = By.id("confirmButton");
    public final By promptButton = By.id("promtButton");

    public AlertsPage clickAndAcceptAlert(By locator) {
        clickElement(locator);
        waitAlertIsVisible();
        acceptAlert();
        return this;
    }

    public AlertsPage clickAndDeclineAlert(By locator) {
        clickElement(locator);
        waitAlertIsVisible();
        dismissAlert();
        return this;
    }

    public AlertsPage clickAlertAndSendText(By locator, String text) {
        clickElement(locator);
        waitAlertIsVisible();
        sendKeysToAlert(text);
        acceptAlert();
        return this;
    }

    public AlertsPage clickFirstAlert() {
        clickAndAcceptAlert(alertButton);
        return this;
    }

    public AlertsPage clickAlertAndWaitToConfirm() {
        clickAndAcceptAlert(timerAlertButton);
        return this;
    }

    public AlertsPage clickAlertAndConfirm() {
        clickAndAcceptAlert(confirmButton);
        waitElementIsClickable(confirmButton);
        clickAndDeclineAlert(confirmButton);
        return this;
    }

    public AlertsPage sendTextToAlert() {
        clickAlertAndSendText(promptButton, "Andrew");
        return this;
    }
}
