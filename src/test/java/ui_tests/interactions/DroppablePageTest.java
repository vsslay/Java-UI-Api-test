package ui_tests.interactions;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.DROPPABLE_PAGE;

public class DroppablePageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(DROPPABLE_PAGE);
    }

    @Test
    public void checkPropTab() {
        droppablePage.checkPropTab();
    }

    @Test
    public void checkRevertTab() {
        droppablePage.checkRevertTab();
    }

    @Test
    public void checkAcceptTab() {
        droppablePage.checkAcceptDropTab();
    }

    @Test
    public void checkSimpleTab() {
        droppablePage.checkSimpleTab();
    }


}
