package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class ToolTipsPage extends BasePage {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    public final By toolTipButton = By.id("toolTipButton");
    public final By textFieldToolTopContainer = By.id("texFieldToolTopContainer");
    public final By firstTooltipInText = By.id("//div[@id='texToolTopContainer']/a[1]");
    public final By secondTooltipInText = By.id("//div[@id='texToolTopContainer']/a[2]");

    @SuppressWarnings("UnusedReturnValue")
    public ToolTipsPage hoverAndCheckTooltips() {
        focusOnElement(toolTipButton);
        String toolTipBtn = getElementAttribute(toolTipButton, "title");
        if (toolTipBtn.contains("hovered")) {
            focusOnElement(textFieldToolTopContainer);
            String toolTipInput = getElementAttribute(textFieldToolTopContainer, "title");
            if (toolTipInput.contains("hovered")) {
                focusOnElement(firstTooltipInText);
                focusOnElement(secondTooltipInText);
            }
        }
        return this;
    }
}
