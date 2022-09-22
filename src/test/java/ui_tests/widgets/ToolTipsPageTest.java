package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.TOOL_TIPS_PAGE;

public class ToolTipsPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(TOOL_TIPS_PAGE);
    }

    @Test
    public void hoverAndCheckTooltips() {
        toolTipsPage.hoverAndCheckTooltips();
    }
}
