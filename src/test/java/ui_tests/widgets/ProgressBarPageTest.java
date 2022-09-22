package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.PROGRESS_BAR_PAGE;

public class ProgressBarPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(PROGRESS_BAR_PAGE);
    }

    @Test
    public void checkProgressBar() {
        progressBarPage.checkProgressBar();
    }
}
