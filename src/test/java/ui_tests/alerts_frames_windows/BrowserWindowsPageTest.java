package ui_tests.alerts_frames_windows;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.BROWSER_WINDOW_PAGE;

public class BrowserWindowsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(BROWSER_WINDOW_PAGE);
    }

    @Test(testName = "Check message", groups = "Alerts, frames, windows page")
    @Description("Check message")
    @Severity(SeverityLevel.NORMAL)
    public void openNewTab() {
        browserWindowsPage.openTab();
    }

    @Test(testName = "Open new window", groups = "Alerts, frames, windows page")
    @Description("Open window")
    @Severity(SeverityLevel.CRITICAL)
    public void openNewWindow() {
        browserWindowsPage.openWindow();
    }

    @Test(testName = "Open message", groups = "Alerts, frames, windows page")
    @Description("Open message")
    @Severity(SeverityLevel.MINOR)
    public void openNewMessage() {
        browserWindowsPage.openMessage();
    }
}
