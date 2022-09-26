package ui_tests.interactions;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.DRAGGABLE_PAGE;

public class DraggablePageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(DRAGGABLE_PAGE);
    }

    @Test
    public void checkAxisRestrictionTab() {
        draggablePage.checkAxisRestrictedTab();
    }

    @Test
    public void checkContainerRestrictionTab() {
        draggablePage.checkContainerRestrictedTab();
    }

    @Test
    public void checkCursorRestrictionTab() {
        draggablePage.checkCursorStyleTab();
    }

    @Test
    public void checkSimpleTab() {
        draggablePage.checkSimplePage();
    }
}
