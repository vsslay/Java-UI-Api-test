package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.TABS_PAGE;

public class TabsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(TABS_PAGE);
    }

    @Test
    public void clickAndCheckText() {
        tabsPage.clickAccordionsAndCheckText();
    }
}
