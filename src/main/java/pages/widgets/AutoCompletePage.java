package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class AutoCompletePage extends BasePage {
    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    public final By autoCompleteMultipleInput = By.id("autoCompleteMultipleInput");
    public final By autoCompleteSingleInput = By.id("autoCompleteSingleInput");
    public final By clearColorsInMultipleComplete =
            By.xpath("//div[@class='auto-complete__indicators css-1wy0on6']/div");

    public AutoCompletePage inputMultipleColors() {
        inputTextAndPressTab(autoCompleteMultipleInput, "bla");
        inputTextAndPressTab(autoCompleteMultipleInput, "whi");
        inputTextAndPressTab(autoCompleteMultipleInput, "re");
        return this;
    }

    public AutoCompletePage inputOneColor() {
        inputTextAndPressTab(autoCompleteSingleInput, "re");
        return this;
    }

    public AutoCompletePage clearAllColors() {
        clickElement(clearColorsInMultipleComplete);
        return this;
    }

}
