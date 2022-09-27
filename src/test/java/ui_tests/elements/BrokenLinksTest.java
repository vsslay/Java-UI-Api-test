package ui_tests.elements;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.BROKEN_LINKS_PAGE;

public class BrokenLinksTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(BROKEN_LINKS_PAGE);
    }

    @Test(groups = "Elements page", testName = "Check images on page")
    @Description("This test checks all images on page")
    @Severity(SeverityLevel.NORMAL)
    public void checkAllImages() {
        brokenLinksPage.checkImagesOnPage();
        brokenLinksPage.checkBrokenImageOnPage();
    }

    @Test
    public void checkStatusCode() {
        brokenLinksPage.apiCall();
    }
}
