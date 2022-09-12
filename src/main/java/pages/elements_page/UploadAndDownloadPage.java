package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

import static constants.constant.Paths.DOWNLOAD_FOLDER_PATH;
import static constants.constant.Paths.UPLOAD_FOLDER_PATH;

@SuppressWarnings("UnusedReturnValue")
public class UploadAndDownloadPage extends BasePage {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    private final By downloadButton =By.id("downloadButton");
    private final By uploadFile = By.id("uploadFile");
    public final By uploadConfirmation = By.id("uploadedFilePath");

    public UploadAndDownloadPage downloadFile() {
        clickElement(downloadButton);
        checkFileIsDownloaded("sampleFile.jpeg", DOWNLOAD_FOLDER_PATH);
        return this;
    }

    public UploadAndDownloadPage uploadFile() {
        sendKeys(uploadFile, UPLOAD_FOLDER_PATH + "avatar.jpg");
        waitElementIsVisible(uploadConfirmation);
        return this;
    }
}
