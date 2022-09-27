package pages.book_store_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public final By userName = By.id("userName");
    public final By userPass = By.id("password");
    public final By loginBtn = By.id("login");

    @SuppressWarnings({"UnusedReturnValue", "SpellCheckingInspection"})
    public LoginPage login() {
        sendKeys(userName, "Usernamesample");
        sendKeys(userPass, "QaWsEd123!@#");
        clickElement(loginBtn);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public LoginPage checkLoginSuccessful(String expectedUrl) {
        isOpened(expectedUrl);
        return this;
    }
}
