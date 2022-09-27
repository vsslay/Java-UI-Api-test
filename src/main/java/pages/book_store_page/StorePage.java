package pages.book_store_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    public final By loginBtn = By.id("login");
    public final By userName = By.id("userName");
    public final By searchBox = By.id("searchBox");
    public final By book = By.xpath("//div/span/a");
    public final By getBackBtn = By.xpath("//button[contains(text(),'Back')]");
    public final By addNewRecordButton = By.xpath("//button[contains(text(),'Add To Your Collection')]");

    @SuppressWarnings("UnusedReturnValue")
    public StorePage goToLoginPage() {
        clickElement(loginBtn);
        waitElementIsVisible(userName);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public StorePage findAndAddBook(String bookName) {
        waitElementIsVisible(searchBox);
        clearKeys(searchBox);
        sendKeys(searchBox, bookName);
        waitElementIsVisible(book);
        clickElement(book);
        waitElementIsVisible(addNewRecordButton);
        jsClick(addNewRecordButton);
        waitAlertIsVisible();
        acceptAlert();
        waitElementIsVisible(getBackBtn);
        jsClick(getBackBtn);
        return this;
    }

}
