package ui_tests.alerts_frames_windows;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.FRAMES_PAGE;

public class FramesPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(FRAMES_PAGE);
    }

    @Test
    public void switchBetweenFrames() {
        framesPage.switchBetweenFrames();
    }
}
