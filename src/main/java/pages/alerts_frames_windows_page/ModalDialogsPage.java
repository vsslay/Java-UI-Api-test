package pages.alerts_frames_windows_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class ModalDialogsPage extends BasePage {
    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public final By showSmallModal = By.id("showSmallModal");
    public final By showLargeModal = By.id("showLargeModal");
    public final By closeSmallModal = By.id("closeSmallModal");
    public final By closeLargeModal = By.id("closeLargeModal");
    public final By modalText = By.xpath("//div[@class='modal-body']");

    public ModalDialogsPage clickAndCheckSmallModal() {
        clickElement(showSmallModal);
        String text = getElementText(modalText);
        if (text.contains("This is a small modal")) {
            clickElement(closeSmallModal);
        }
        return this;
    }

    public ModalDialogsPage clickAndCheckLargeModal() {
        clickElement(showLargeModal);
        String text = getElementText(modalText);
        if (text.contains("Lorem Ipsum is simply dummy text")) {
            clickElement(closeLargeModal);
        }
        return this;
    }
}
