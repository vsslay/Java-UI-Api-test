package ui_tests.alerts_frames_windows;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.ALERTS_PAGE;

public class AlertsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(ALERTS_PAGE);
    }

    @Test
    public void testAlert() {
        alertsPage.clickFirstAlert();
    }

    @Test
    public void testAlertAfterFiveSeconds() {
        alertsPage.clickAlertAndWaitToConfirm();
    }

    @Test
    public void testAlertAcceptThanDecline() {
        alertsPage.clickAlertAndConfirm();
    }

    @Test
    public void testAlertSendTextAndAccept() {
        alertsPage.sendTextToAlert();
    }
}
