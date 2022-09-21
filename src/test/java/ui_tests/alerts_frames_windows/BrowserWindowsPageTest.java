package ui_tests.alerts_frames_windows;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.BROWSER_WINDOW_PAGE;

public class BrowserWindowsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(BROWSER_WINDOW_PAGE);
    }

    @Test
    public void openNewTab() {
        browserWindowsPage.openTab();
    }

    @Test
    public void openNewWindow() {
        browserWindowsPage.openWindow();
    }

    @Test
    public void openNewMessage() {
        browserWindowsPage.openMessage();
    }
}
