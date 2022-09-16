package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class DynamicPropPage extends BasePage{
    public DynamicPropPage(WebDriver driver) {
        super(driver);
    }

    public final By fiveSecondsButton = By.id("enableAfter");
    public final By colorChangeButton = By.id("colorChange");
    public final By visibleAfterFiveSecondsButton = By.id("visibleAfter");

    public DynamicPropPage clickAfterFiveSeconds () {
        waitElementIsClickable(fiveSecondsButton);
        clickElement(fiveSecondsButton);
        return this;
    }

    @SuppressWarnings("StringOperationCanBeSimplified")
    public DynamicPropPage clickAfterColorChanged () {
        WebElement button = driver.findElement(colorChangeButton);
        String color = new String();
        while (color.equals("#FFFFFF")) {
            color = button.getAttribute("color");
        clickElement(colorChangeButton);
        }
        return this;
    }

    public DynamicPropPage clickWhenVisible () {
        waitElementIsVisible(visibleAfterFiveSecondsButton);
        clickElement(visibleAfterFiveSecondsButton);
        return this;
    }
}

