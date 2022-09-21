package pages.alerts_frames_windows_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

import java.util.Objects;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public final By iFrameOne = By.id("frame1");
    public final By iFrameTwo = By.id("frame2");
    public final By frameHeading = By.id("sampleHeading");

    @SuppressWarnings("UnusedReturnValue")
    public FramesPage switchBetweenFrames() {
        switchBetweenFrames(iFrameOne);
        String textFrameOne = getElementText(frameHeading);
        switchToParentFrame();
        switchBetweenFrames(iFrameTwo);
        String textFrameTwo = getElementText(frameHeading);
        if (Objects.equals(textFrameTwo, textFrameOne)) {
            switchToParentFrame();
        }
        return this;
    }

}
