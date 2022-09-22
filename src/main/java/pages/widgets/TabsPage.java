package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class TabsPage extends BasePage {
    public TabsPage(WebDriver driver) {
        super(driver);
    }

    public final By demoTabWhat = By.id("demo-tab-what");
    public final By demoTabOrigin = By.id("demo-tab-origin");
    public final By demoTabUse = By.id("demo-tab-use");
    public final By demoText = By.xpath("//div[@id='demo-tabpane-what']/p");
    public final By originText = By.xpath("//div[@id='demo-tabpane-origin']/p");
    public final By useText = By.xpath("//div[@id='demo-tabpane-use']/p");

    @SuppressWarnings("UnusedReturnValue")
    public TabsPage clickAccordionsAndCheckText() {
        clickElement(demoTabWhat);
        if (getElementText(demoText).contains("Lorem Ipsum is simply dummy text")) {
            clickElement(demoTabOrigin);
            if (getElementText(originText).contains("Lorem Ipsum is simply dummy text")) {
                clickElement(demoTabUse);
                if (getElementText(useText).contains("Lorem Ipsum is simply dummy text")) {
                    return this;
                }
            }
        }
        return this;
    }
}
