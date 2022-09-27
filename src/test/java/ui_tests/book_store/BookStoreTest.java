package ui_tests.book_store;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.*;

public class BookStoreTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(BOOKSTORE_PAGE);
        bookStorePage.goToLoginPage();
        loginPage.isOpened(LOGIN_PAGE);
        loginPage.login();
        loginPage.checkLoginSuccessful(BOOKSTORE_PAGE);
    }

    @Test
    public void addBooks() {
        bookStorePage.findAndAddBook("Git Pocket");
        bookStorePage.findAndAddBook("Learning");
        bookStorePage.findAndAddBook("Speaking");
        basePage.open(PROFILE_PAGE);
    }

    @Test
    public void deleteBooks() {
        if (!(basePage.isOpened(PROFILE_PAGE))) {
            basePage.open(PROFILE_PAGE);
        }
        profilePage.deleteOneBook("Git Pocket");
        profilePage.deleteAllBooks();
    }
}
