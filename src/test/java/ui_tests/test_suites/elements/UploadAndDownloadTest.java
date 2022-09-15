package ui_tests.test_suites.elements;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui_tests.base.BaseTest;

import static constants.constant.Urls.UPLOAD_AND_DOWNLOAD_PAGE;

public class UploadAndDownloadTest extends BaseTest {

    @BeforeTest
    private void navigateOnPage(){
        basePage.open(UPLOAD_AND_DOWNLOAD_PAGE);
    }

    @Test(groups = "Upload and download page",
            testName = "Download file")
    @Description("Download file and check file is downloaded")
    @Severity(SeverityLevel.NORMAL)
    public void downloadAndCheckFileIsDownloaded() {
        uploadAndDownloadPage.downloadFile();
    }

    @Test(groups = "Upload and download page",
            testName = "Upload file")
    @Description("Upload file and check file is uploaded")
    @Severity(SeverityLevel.NORMAL)
    public void uploadAndCheckFileIsUploaded() {
        uploadAndDownloadPage.uploadFile();
    }
}
