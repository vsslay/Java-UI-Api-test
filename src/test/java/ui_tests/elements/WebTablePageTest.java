package ui_tests.elements;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.WEB_TABLES_PAGE;

public class WebTablePageTest extends BaseTest {

    @BeforeTest
    public void navigateOnPage() {
        basePage.open(WEB_TABLES_PAGE);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void inputDataToWebTable () {
        webTablePage.inputDataToWebTable();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    public void checkElementGrid () {
        webTablePage.checkGridOfElements();
    }
}
