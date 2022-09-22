package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.AUTO_COMPLETE_PAGE;

public class AutoCompletePageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(AUTO_COMPLETE_PAGE);
    }

    @Test
    public void inputOneColor(){
        autoCompletePage.inputOneColor();
    }

    @Test
    public void inputMultipleColors(){
        autoCompletePage.inputMultipleColors();
    }

    @Test
    public void clearColors(){
        autoCompletePage.clearAllColors();
    }
}
