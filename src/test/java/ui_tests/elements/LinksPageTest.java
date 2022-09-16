package ui_tests.elements;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.LINKS_PAGE;

public class LinksPageTest extends BaseTest {

    @BeforeTest
    public void navigateOnPage() {
        basePage.open(LINKS_PAGE);
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void clickAndCheckSimpleLink() {
        linksPage.clickSimpleLink();
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void clickAndCheckDynamicLink() {
        linksPage.clickDynamicLink();
    }
}
