package pages.interactions_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class SelectablePage extends BasePage {
    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    public final By clickableList = By.id("demo-tab-list");
    public final By clickableGrid = By.id("demo-tab-grid");
    public final By verticalListContainer = By.xpath("//ul[@id='verticalListContainer']/li");
    public final By rowListContainer = By.xpath("//div[contains(@id,'row')]/li");

    @SuppressWarnings("UnusedReturnValue")
    public SelectablePage checkGridTab() {
        clickElement(clickableGrid);
        scrollDownPage(0,100);
        clickMultipleElements(rowListContainer);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public SelectablePage checkListTab() {
        clickElement(clickableList);
        clickMultipleElements(verticalListContainer);
        return this;
    }
}
