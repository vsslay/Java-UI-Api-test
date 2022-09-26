package ui_tests.interactions;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.SORTABLE_PAGE;

public class SortablePageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(SORTABLE_PAGE);
    }

    @Test
    public void checkGridTab() {
        sortablePage.checkGridTab();
    }

    @Test
    public void checkListTab() {
        sortablePage.checkListTab();
    }
}
