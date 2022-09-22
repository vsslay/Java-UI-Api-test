package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public final By mainItem1 = By.xpath( "//a[contains(text(),'Main Item 1')]");
    public final By mainItem2 = By.xpath("//a[contains(text(),'Main Item 2')]");
    public final By mainItem3 = By.xpath("//a[contains(text(),'Main Item 3')]");

    public final By subItem1 = By.xpath("//ul[@id='nav']/li/ul/li[1]");
    public final By subItem2 = By.xpath("//ul[@id='nav']/li/ul/li[2]");
    public final By subSubList = By.xpath("//ul[@id='nav']/li/ul/li[3]");

    public final By subSubItem1 = By.xpath("//ul[@id='nav']/li/ul/li/ul/li[1]");
    public final By subSubItem2 = By.xpath("//ul[@id='nav']/li/ul/li/ul/li[2]");

    @SuppressWarnings("UnusedReturnValue")
    public MenuPage clickThroughItems() {
        clickElement(mainItem1);
        clickElement(mainItem3);
        clickElement(mainItem2);
        clickElement(subItem1);
        clickElement(subItem2);
        clickElement(subSubList);
        clickElement(subSubItem1);
        clickElement(subSubItem2);
        return this;
    }
}
