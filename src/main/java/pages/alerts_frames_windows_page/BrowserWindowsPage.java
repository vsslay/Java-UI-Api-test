package pages.alerts_frames_windows_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public final By tabButton = By.id("tabButton");
    public final By windowButton = By.id("windowButton");
    public final By messageWindowButton = By.id("messageWindowButton");

    public BrowserWindowsPage openNewWindow (By page) {
        String origin = driver.getWindowHandle();
        clickElement(page);
        switchToNewWindow();
        switchToOriginalWindow(origin);
        return this;
    }

    public BrowserWindowsPage openTab() {
        openNewWindow(tabButton);

        return this;
    }

    public BrowserWindowsPage openWindow() {
        openNewWindow(windowButton);
        return this;
    }

    public BrowserWindowsPage openMessage() {
        openNewWindow(messageWindowButton);
        return this;
    }

}
