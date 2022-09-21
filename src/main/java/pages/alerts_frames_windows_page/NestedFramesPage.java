package pages.alerts_frames_windows_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

import java.util.Objects;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public final By iFrameOne = By.id("frame1");
    public final By iFrameTwo = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
    public final By frameHeading = By.tagName("body");

    @SuppressWarnings("UnusedReturnValue")
    public NestedFramesPage switchBetweenFrames() {
        switchBetweenFrames(iFrameOne);
        String textFrameOne = getElementText(frameHeading);
        if (Objects.equals(textFrameOne, "Parent frame")) {
            switchBetweenFrames(iFrameTwo);
            String textFrameTwo = getElementText(frameHeading);
            if (Objects.equals(textFrameTwo, "Child Iframe")) {
                driver.switchTo().parentFrame();
            }
        }
        return this;
    }
}
