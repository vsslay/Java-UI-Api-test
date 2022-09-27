package pages.interactions_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class SortablePage extends BasePage {
    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public final By demoTabGrid = By.id("demo-tab-grid");
    public final By demoTabList = By.id("demo-tab-list");
    @SuppressWarnings("SpellCheckingInspection")
    public final By sortableList = By.xpath("//div[@id='demo-tabpane-list']/div/div");
    public final By sortableGrid = By.xpath("//div[@class='create-grid']/div");

    public SortablePage checkGridTab() {
        clickElement(demoTabGrid);
        waitElementIsVisible(sortableGrid);
        WebElement elementToDrag = chooseElementByIndex(sortableGrid, 1);
        WebElement elementToDrop = chooseElementByIndex(sortableGrid, 5);
        dragAndDropWebElementToElement(elementToDrag, elementToDrop);
        return this;
    }

    public SortablePage checkListTab() {
        clickElement(demoTabList);
        waitElementIsVisible(sortableList);
        WebElement elementToDrag = chooseElementByIndex(sortableList, 1);
        WebElement elementToDrop = chooseElementByIndex(sortableList, 5);
        dragAndDropWebElementToElement(elementToDrag, elementToDrop);
        return this;
    }
}
