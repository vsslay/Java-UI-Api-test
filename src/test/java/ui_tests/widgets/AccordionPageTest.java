package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.ACCORDION_PAGE;

public class AccordionPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(ACCORDION_PAGE);
    }

    @Test
    public void clickTabsAndCheckText(){
        accordionPage.clickAccordionsAndCheckText();
    }
}
