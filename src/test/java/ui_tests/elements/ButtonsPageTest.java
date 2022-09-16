package ui_tests.elements;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.BUTTONS_PAGE;

public class ButtonsPageTest extends BaseTest {

    @BeforeTest
    public void openPage() {
        basePage.open(BUTTONS_PAGE);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void doubleClickButton () {
        buttonsPage.doubleClickButton();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void rightClickButton () {
        buttonsPage.rightClickButton();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void clickButton () {
        buttonsPage.clickButtonWithDynamicId();
    }
}
