package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public final By simpleLink = By.id("simpleLink");
    public final By dynamicLink = By.id("dynamicLink");
    public final By newPageOpenedLocator = By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div");


    public LinksPage clickSimpleLink() {

        clickElement(simpleLink);
        waitElementIsVisible(newPageOpenedLocator);
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        return this;
    }

    public LinksPage clickDynamicLink() {

        clickElement(dynamicLink);
        waitElementIsVisible(newPageOpenedLocator);
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
        return this;
    }

    public void apiCall(Integer expectedCode) {
        checkStatusCode(simpleLink, expectedCode);
    }

}