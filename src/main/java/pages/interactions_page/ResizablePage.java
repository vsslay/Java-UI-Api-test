package pages.interactions_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class ResizablePage extends BasePage {
    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public final By resizableBoxWithRestriction =
            By.xpath("//div[@id='resizableBoxWithRestriction']/span");
    public final By resizableBox = By.xpath("//div[@id='resizable']/span");

    @SuppressWarnings("UnusedReturnValue")
    public ResizablePage checkResizableBoxWithRestrictions() {
        waitElementIsVisible(resizableBoxWithRestriction);
        dragAndDropElementByCoordinates(resizableBoxWithRestriction, -50, 50);
        dragAndDropElementByCoordinates(resizableBoxWithRestriction, 350, -150);
        dragAndDropElementByCoordinates(resizableBox, 100, -100);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public ResizablePage checkResizableBox() {
        waitElementIsVisible(resizableBox);
        dragAndDropElementByCoordinates(resizableBox, 100, -100);
        return this;
    }
}
