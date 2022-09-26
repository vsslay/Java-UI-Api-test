package ui_tests.interactions;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.SELECTABLE_PAGE;

public class SelectablePageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(SELECTABLE_PAGE);
    }

    @Test
    public void checkGridTab() {
        selectablePage.checkGridTab();
    }

    @Test
    public void checkListTab() {
        selectablePage.checkListTab();
    }
}
