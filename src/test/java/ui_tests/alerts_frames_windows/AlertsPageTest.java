package ui_tests.alerts_frames_windows;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.ALERTS_PAGE;

public class AlertsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(ALERTS_PAGE);
    }

    @Test(testName = "Accept alert", groups = "Alerts, frames, windows page")
    @Description("Confirm alert")
    @Severity(SeverityLevel.NORMAL)
    public void testAlert() {
        alertsPage.clickFirstAlert();
    }

    @Test(testName = "Accept first alert after 5 seconds", groups = "Alerts, frames, windows page")
    @Description("Confirm alert after wait")
    @Severity(SeverityLevel.NORMAL)
    public void testAlertAfterFiveSeconds() {
        alertsPage.clickAlertAndWaitToConfirm();
    }

    @Test(testName = "Accept or decline alert", groups = "Alerts, frames, windows page")
    @Description("Confirm alert from choice")
    @Severity(SeverityLevel.NORMAL)
    public void testAlertAcceptThanDecline() {
        alertsPage.clickAlertAndConfirm();
    }

    @Test(testName = "Accept alert after sending text", groups = "Alerts, frames, windows page")
    @Description("Confirm alert with text")
    @Severity(SeverityLevel.CRITICAL)
    public void testAlertSendTextAndAccept() {
        alertsPage.sendTextToAlert();
    }
}
