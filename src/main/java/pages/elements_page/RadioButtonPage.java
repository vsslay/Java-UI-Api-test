package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base_page.BasePage;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class RadioButtonPage extends BasePage {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public final By radioButton = By.xpath("//input[@type='radio']");
    public final By confirmationIndicator = By.xpath("//p/span");

    public RadioButtonPage clickRadioButtonsAndCheckConfirmation() {
        jsClickMultipleElements(radioButton);
        waitElementIsVisible(confirmationIndicator);
        return this;
    }

    public RadioButtonPage clickInactiveRadiobutton() {
        List<WebElement> elements = driver.findElements(radioButton);
        WebElement element = elements.get(2);
        String isDisabled = element.getAttribute("disabled");
        Assert.assertEquals(isDisabled, "true");
        return this;
    }
}
