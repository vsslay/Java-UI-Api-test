package pages.book_store_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public final By searchBox = By.id("searchBox");
    public final By deleteAccount = By.xpath("//button[contains(text(),'Account')]");
    public final By deleteAllBooks = By.xpath("//button[contains(text(),'All Books')]");
    public final By deleteRecord = By.id("delete-record-undefined");
    public final By deleteConfirm = By.id("closeSmallModal-ok");

    @SuppressWarnings("UnusedReturnValue")
    public ProfilePage deleteOneBook(String bookName) {
        sendKeys(searchBox, bookName);
        jsClick(deleteRecord);
        waitElementIsVisible(deleteConfirm).click();
        waitAlertIsVisible();
        acceptAlert();
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public ProfilePage deleteAllBooks() {
        jsClick(deleteAllBooks);
        waitElementIsVisible(deleteConfirm).click();
        waitAlertIsVisible();
        acceptAlert();
        return this;
    }

    @SuppressWarnings("unused")
    public ProfilePage deleteAccount() {
        clickElement(deleteAccount);
        return this;
    }

}
