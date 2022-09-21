package ui_tests.alerts_frames_windows;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.MODAL_DIALOGS_PAGE;

public class ModalDialogsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(MODAL_DIALOGS_PAGE);
    }

    @Test
    public void checkSmallModal() {
        modalDialogsPage.clickAndCheckSmallModal();
    }

    @Test
    public void checkLargeModal() {
        modalDialogsPage.clickAndCheckLargeModal();
    }
}
