package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static common.config.*;
import static constants.constant.Paths.DOWNLOAD_FOLDER_PATH;
import static constants.constant.TimeoutVar.IMPLICIT_WAIT_5_SEC;

public class CommonActions {
    @SuppressWarnings({"ConstantConditions", "deprecation"})
    public static WebDriver createDriver() {
        WebDriver driver = null;

        File downloadFolder = new File(DOWNLOAD_FOLDER_PATH);
        //noinspection ResultOfMethodCallIgnored
        downloadFolder.mkdir();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", DOWNLOAD_FOLDER_PATH);

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome" -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
            }
            case "win_opera" -> {
                System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver.exe");
                OperaOptions options = new OperaOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new OperaDriver(options);
            }
            case "win_firefox" -> {
                System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            case "win_edge" -> {

                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.setExperimentalOption("prefs", prefs);
                driver = new EdgeDriver(options);
            }
            case "win_chrome_headless" -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.setHeadless(true);
                driver = new ChromeDriver(options);
            }
            case "win_firefox_headless" -> {
                System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                driver = new FirefoxDriver(options);
            }
            case "win_edge_headless" -> {
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.setHeadless(true);
                driver = new EdgeDriver(options);
            }
            default -> Assert.fail("Something went wrong with webdriver: " + PLATFORM_AND_BROWSER);
        }
        switch (SET_WINDOW_SIZE) {
            case "maximize" -> {
                driver.manage().window().maximize();
            }
            case "minimize" -> {
                driver.manage().window().minimize();
            }
            case "fullscreen" -> {
                driver.manage().window().fullscreen();
            }
            default -> Assert.fail("Error while setting window size: " + SET_WINDOW_SIZE);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_5_SEC));
        return driver;
    }
}
