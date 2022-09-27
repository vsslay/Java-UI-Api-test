package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class ProgressBarPage extends BasePage {
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public final By startStopButton = By.id("startStopButton");
    public final By resetButton = By.id("resetButton");
    public final By progressBar = By.xpath("//*[@id='progressBar']/div");

    @SuppressWarnings({"UnnecessaryLocalVariable", "SpellCheckingInspection"})
    public String getAttributeValue () {
        String valueNow = getElementAttribute(progressBar, "aria-valuenow");
        return valueNow;
    }
    @SuppressWarnings("UnusedReturnValue")
    public ProgressBarPage checkProgressBar() {
        Object a = getElementAttributes(progressBar);
        System.out.println(a.toString());
        clickElement(startStopButton);
        String valueNow = getAttributeValue();
        while (!(valueNow.equals("100"))) {
            valueNow = getAttributeValue();
        }
        clickElement(resetButton);
        return this;
    }
}
