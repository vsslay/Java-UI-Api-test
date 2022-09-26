package ui_tests.interactions;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.RESIZABLE_PAGE;

public class ResizablePageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(RESIZABLE_PAGE);
    }

    @Test
    public void checkResizableBoxRestricted() {
        resizablePage.checkResizableBoxWithRestrictions();
    }

    @Test
    public void checkResizableBox() {
        resizablePage.checkResizableBox();
    }
}
