package ui_tests.elements;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import base.BaseTest;
import static constants.constant.Urls.TEXT_BOX_PAGE;

public class TextBoxTest extends BaseTest {

    @Test (groups = "Elements page", testName = "Fulfill form and submit test", suiteName = "Text box page test suite")
    @Description("Input data to text fields, presses submit button, check if confirmation and values appeared")
    @Severity(SeverityLevel.NORMAL)
    public void sendKeysAndSubmit() {
        basePage.open(TEXT_BOX_PAGE);
        textBoxPage
                .inputAddresses()
                .inputFullName()
                .inputEmail()
                .clickSubmit()
                .checkConfirmationValues();
    }
}
