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
    public final By linksOnPage = By.xpath("//div[@class='row']/div/div/a");

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

    public BrokenLinksPage checkLinksOnPage() {
        List<WebElement> links = driver.findElements(linksOnPage).stream().toList();
        int iterations = 0;
        while (iterations != links.size()) {
            WebElement element = links.get(iterations);
            scrollDownPage(0, 500);
            element.click();
            driver.navigate().back();
            iterations++;
        }
        return this;
    }
}