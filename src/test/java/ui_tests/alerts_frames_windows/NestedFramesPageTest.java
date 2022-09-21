package ui_tests.alerts_frames_windows;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.NESTED_FRAMES_PAGE;

public class NestedFramesPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(NESTED_FRAMES_PAGE);
    }

    @Test
    public void switchBetweenFrames() {
        nestedFramesPage.switchBetweenFrames();
    }
}
