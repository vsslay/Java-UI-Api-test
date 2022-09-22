package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public final By selectValueInput = By.xpath("//div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/input");
    public final By selectOneInput = By.xpath("//div[2]/div[2]/div[4]/div/div/div/div[1]/div[2]/div/input");
    public final By oldSelectMenu = By.id("oldSelectMenu");
    public final By selectMultipleInput = By.xpath("//div[7]/div/div/div/div[1]/div[2]/div/input");
    public final By standardMultiSelect = By.id("cars");

    @SuppressWarnings("UnusedReturnValue")
    public SelectMenuPage inputAllForms() {
        sendKeys(selectValueInput, "Group 1, option 1");
        selectByIndex(oldSelectMenu, 3);
        sendKeys(selectOneInput, "Mrs.");
        sendKeys(selectMultipleInput, "Red");
        driver.findElement(selectMultipleInput).sendKeys(Keys.TAB);
        selectByValue(standardMultiSelect, "volvo");
        return this;
    }
}
