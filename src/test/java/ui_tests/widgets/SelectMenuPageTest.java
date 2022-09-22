package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.SELECT_MENU_PAGE;

public class SelectMenuPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(SELECT_MENU_PAGE);
    }

    @Test
    public void checkSelections() {
        selectMenuPage.inputAllForms();
    }
}
