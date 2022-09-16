package ui_tests.elements;

import base.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.DYNAMIC_PROPERTIES_PAGE;

public class DynamicPropPageTest extends BaseTest {

    @BeforeTest
    public void navigateOnPage() {
        basePage.open(DYNAMIC_PROPERTIES_PAGE);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void clickAfterEnable() {
        dynamicPropPage.clickAfterFiveSeconds();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void clickAfterColorChange() {
        dynamicPropPage.clickAfterColorChanged();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void clickAfterVisible() {
        dynamicPropPage.clickWhenVisible();
    }
}
