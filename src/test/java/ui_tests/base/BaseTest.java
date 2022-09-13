package ui_tests.base;

import common.CommonActions;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import pages.base_page.BasePage;
import pages.elements_page.CheckBoxPage;
import pages.elements_page.TextBoxPage;
import pages.elements_page.UploadAndDownloadPage;
import pages.form_page.PracticeFormPage;

import static common.config.*;


public class BaseTest implements ITestListener{
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);

//_________________________ Initialization _______________________________________________
    protected PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
    protected TextBoxPage textBoxPage = new TextBoxPage(driver);
    protected CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
    protected UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage(driver);



    @AfterClass
    public void clearCookiesAndStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterClass(alwaysRun = true)
    public void close() {
        if (CLOSE_BROWSER_AFTER_TESTS) {
            driver.quit();
        }
    }

    @AfterMethod(description = "Taking screenshot")
    public void onTestFailure (ITestResult result) {
        ITestListener.super.onTestFailure(result);
        saveScreenshotOnFailure(driver);
        saveLog(result.getMethod().getConstructorOrMethod().getName());
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshotOnFailure(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment (value = "TestLog", type = "text/plain")
    public static String saveLog(String message) {
        return message;
    }

}
