package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public final By doubleClickBtn = By.id("doubleClickBtn");
    public final By rightClickBtn = By.id("rightClickBtn");
    public final By dynamicIdBtn = By.xpath("//button[text()='Click Me']");

    public ButtonsPage doubleClickButton () {
        doubleClick(doubleClickBtn);
        return this;
    }

    public ButtonsPage rightClickButton () {
        contextClick(rightClickBtn);
        return this;
    }

    public  ButtonsPage clickButtonWithDynamicId() {
        clickElement(dynamicIdBtn);
        return this;
    }
}
