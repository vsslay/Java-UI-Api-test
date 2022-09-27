package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base_page.BasePage;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public final By searchBox = By.id("searchBox");
    @SuppressWarnings("SpellCheckingInspection")
    public final By gridOfElements = By.xpath("//div[@role='grid']/div[@class='rt-tbody']/div");
    public final By selectRows = By.xpath("//select/option[3]");

    @SuppressWarnings("SpellCheckingInspection")
    public WebTablePage inputDataToWebTable() {
        sendKeys(searchBox, "erra");
        jsClick(selectRows);
        return this;
    }

    public WebTablePage checkGridOfElements() {
        List<String> listForResults = new ArrayList<>();
        List<WebElement> listOfElements = driver.findElements(gridOfElements);
        int sizeOfValues = listOfElements.size();
        int count = 0;
        while (count < sizeOfValues) {
            String text = listOfElements.get(count).getText();
            listForResults.add(text);
            count++;
        }
        Assert.assertEquals(listOfElements.size(), listForResults.size());
        return this;
    }
}
