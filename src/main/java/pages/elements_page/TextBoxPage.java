package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    private final By fullName = By.xpath("//input[@placeholder='Full Name']");
    private final By eMail = By.id("userEmail");
    private final By addressesCurrentAndPermanent = By.xpath("//textarea[contains(@id,'Address')]");
    private final By submitButton = By.xpath("//button[contains(text(),'Submit')]");
    private final By confirmationValues = By.xpath("//*[@id='output']//p");

    public TextBoxPage inputFullName () {
        sendKeys(fullName, "Andrew QAtest");
        return this;
    }

    public TextBoxPage inputEmail() {
        sendKeys(eMail, "testqa@mail.com");
        return this;
    }

    public TextBoxPage inputAddresses() {
        sendTextToMultipleElements(addressesCurrentAndPermanent, "Country, state, city,house111, apt000");
        return this;
    }

    public TextBoxPage clickSubmit() {
        jsClick(submitButton);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public TextBoxPage checkConfirmationValues() {
        List<String> listOfValuesGot = new ArrayList<>();
        compareListsSize(confirmationValues, listOfValuesGot);
        return this;
    }

}
