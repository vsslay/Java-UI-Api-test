package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public final By sliderRange = By.xpath("//input[@type='range']");
    public final By sliderValue = By.id("sliderValue");

    @SuppressWarnings("UnusedReturnValue")
    public SliderPage dragSlider() {
        String valueOfRange = "";
        clickElement(sliderRange);
        while (!(valueOfRange.equals("100"))) {
            holdKey(sliderRange, Keys.ARROW_RIGHT);
            valueOfRange = getElementAttribute(sliderValue, "value");
        }
        return this;
    }
}
