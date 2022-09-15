package ui_tests.elements;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static constants.constant.Urls.RADIO_BUTTON_PAGE;

public class RadioButtonTest extends BaseTest {


    @Test (groups = "Elements page",
            testName = "Click buttons and check result",
            suiteName = "Radiobutton test suit")
    @Description("Clicks active buttons on page")
    @Severity(SeverityLevel.NORMAL)
    public void checkAllCheckboxesClickable() {
        basePage.open(RADIO_BUTTON_PAGE);
        radioButtonPage.clickRadioButtonsAndCheckConfirmation();
    }

    @Test (groups = "Elements page",
            testName = "Click inactive button")
    @Description("Clicking inactive radio button")
    @Severity(SeverityLevel.MINOR)
    public void checkInactiveButton() {
        basePage.open(RADIO_BUTTON_PAGE);
        radioButtonPage.clickInactiveRadiobutton();
    }

}
