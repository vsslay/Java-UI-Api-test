package ui_tests.elements;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import base.BaseTest;
import base.RetryOnFail;

import static constants.constant.Urls.CHECK_BOX_PAGE;

public class CheckBoxTest extends BaseTest {

    @Test (retryAnalyzer = RetryOnFail.class, groups = "Elements page", testName = "Click checkboxes and check result",
    suiteName = "Checkbox test suit")
    @Description("Clicks all checkboxes on page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAllCheckboxesClickable() {
        basePage.open(CHECK_BOX_PAGE);
        checkBoxPage.clickAllCheckboxes()
                .checkResult();
    }
}
