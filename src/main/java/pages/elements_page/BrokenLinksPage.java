package pages.elements_page;

import org.openqa.selenium.*;
import org.testng.Assert;
import pages.base_page.BasePage;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class BrokenLinksPage extends BasePage {
    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    public final By imagesOnPage = By.xpath("//div/img");
    public final By brokenLink = By.xpath("//a[contains(text(),'Broken')]");

    public BrokenLinksPage checkImagesOnPage() {
        List<WebElement> images = driver.findElements(imagesOnPage).stream().toList();
        Dimension size = images.get(0).getSize();
        Dimension expectedSize = new Dimension(347, 100);
        Assert.assertEquals(size, expectedSize);
        return this;
    }

    public BrokenLinksPage checkBrokenImageOnPage() {
        List<WebElement> images = driver.findElements(imagesOnPage).stream().toList();
        Dimension size = images.get(1).getSize();
        Dimension expectedSize = new Dimension(16, 16);
        Assert.assertEquals(size, expectedSize);
        return this;
    }

    public BrokenLinksPage apiCall() {
        checkStatusCode(brokenLink, 500);
        return this;
    }
}