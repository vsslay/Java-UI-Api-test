package ui_tests.practice_form;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseTest;

import static constants.constant.Urls.PRACTICE_FORM_PAGE;


public class PracticeFormTest extends BaseTest {

    @BeforeTest
    private void navigateOnPage() {
        basePage.open(PRACTICE_FORM_PAGE);
    }

    @Test (testName = "Count checkboxes", groups = "Practice form page")
    @Description("Counts amount of checkboxes on page")
    @Severity(SeverityLevel.MINOR)
    public void checkGendersAmount() {
        practiceFormPage.countGenders();
    }

    @Test (testName = "Pick date", groups = "Practice form page")
    @Description("Picks Date")
    @Severity(SeverityLevel.NORMAL)
    public void checkDatePickTable() {
        practiceFormPage.pickDate();
    }

    @Test (testName = "Click submit button", groups = "Practice form page")
    @Description("Clicks submit button")
    @Severity(SeverityLevel.NORMAL)
    public void checkSubmitButton() {
        practiceFormPage.clickSubmitButton();
    }

    @Test (testName = "Practice form full cycle", groups = "Practice form page")
    @Description("Performs full cycle of form test")
    @Severity(SeverityLevel.CRITICAL)
    public void checkValuesTable() {
        practiceFormPage.inputFormData()
                        .pickDate()
                        .clickSubmitButton()
                        .checkTableHasAllValues();
    }

}
