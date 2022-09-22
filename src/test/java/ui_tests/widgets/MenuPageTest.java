package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.MENU_PAGE;

public class MenuPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(MENU_PAGE);
    }

    @Test
    public void checkMenus() {
        menuPage.clickThroughItems();
    }
}
