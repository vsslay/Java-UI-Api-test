package ui_tests.practice_form;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseTest;
import base.RetryOnFail;

import java.util.Random;

import static constants.constant.Urls.PRACTICE_FORM_PAGE;


public class BrokenTests extends BaseTest {

    @BeforeTest
    private void navigateOnPage() {
        basePage.open(PRACTICE_FORM_PAGE);
    }

    @Test (groups = "Elements page", testName = "Fail test")
    @Description("This test fails")
    @Severity(SeverityLevel.BLOCKER)
    public void failureTest() {
        int a = 1;
        int b = 2;
        Assert.assertEquals(a, b);

    }

    @Test (retryAnalyzer = RetryOnFail.class,groups = "Elements page", testName = "Fail test")
    @Description("This test fails")
    @Severity(SeverityLevel.BLOCKER)
    public void passAfterRetry() {
        Random random = new Random();
        int a = random.ints(0,3).findFirst().getAsInt();
        int b = 2;
        Assert.assertEquals(a, b);
    }

    @Test (retryAnalyzer = RetryOnFail.class,groups = "Elements page", testName = "Fail test")
    @Description("This test fails")
    @Severity(SeverityLevel.BLOCKER)
    public void passAfterRetryTwo() {
        Random random = new Random();
        int a = random.ints(0,3).findFirst().getAsInt();
        int b = 2;
        Assert.assertEquals(a, b);
    }

    @Test (retryAnalyzer = RetryOnFail.class,
            groups = "Elements page",
            testName = "Click checkboxes and check result",
            suiteName = "Checkbox test suit")
    @Description("Clicks all checkboxes on page")
    @Severity(SeverityLevel.CRITICAL)
    public void checkAllCheckboxesClickable() {
        checkBoxPage.clickAllCheckboxes()
                .checkResult();
    }
}
