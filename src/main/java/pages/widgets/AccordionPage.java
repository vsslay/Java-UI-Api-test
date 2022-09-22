package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class AccordionPage extends BasePage {
    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public final By accordionContainer = By.xpath("//div[@id='accordianContainer']/div/div");
    public final By accordionText = By.xpath("//div[@id='accordianContainer']/div/div//p");

    @SuppressWarnings("UnusedReturnValue")
    public AccordionPage clickAccordionsAndCheckText() {
        clickElementById(accordionContainer, 0);
        if (getTextById(accordionText, 0).contains("Lorem Ipsum is simply dummy text")) {
            clickElementById(accordionContainer, 1);
            if (getTextById(accordionText, 1).contains("Lorem Ipsum is simply dummy text")) {
                clickElementById(accordionContainer, 2);
                if (getTextById(accordionText, 2).contains("Lorem Ipsum is simply dummy text")) {
                    return this;
                }
            }
        }
        return this;
    }
}
