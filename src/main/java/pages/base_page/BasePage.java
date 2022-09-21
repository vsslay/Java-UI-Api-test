package pages.base_page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static constants.constant.TimeoutVar.EXPLICIT_WAIT_10_SEC;

@SuppressWarnings("unused")
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigate to page with URL
     * @param url defines url to navigate to
     */
    public void open(String url) {
        driver.get(url);
    }

    /**
     * Wait until web-element is visible on page
     * @param locator is a 'By' locator of element on web-page
     */
    @SuppressWarnings("UnusedReturnValue")
    public WebElement waitElementIsVisible(By locator) {
        WebElement element = driver.findElement(locator);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_10_SEC))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public String getElementText(By locator) {
        String text = driver.findElement(locator).getText();
        return text;
    }

    /**
     * Wait until alert is visible on page
     */
    @SuppressWarnings("UnusedReturnValue")
    public void waitAlertIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_10_SEC))
                .until(ExpectedConditions.alertIsPresent());
    }


    /**
     * Wait until web-element is clickable on page
     * @param locator is a 'By' locator of element on web-page
     */
    @SuppressWarnings("UnusedReturnValue")
    public WebElement waitElementIsClickable(By locator) {
        WebElement element = driver.findElement(locator);
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_10_SEC))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /**
     * Count web-elements by locator
     * @param locator is a 'By' locator of element on web-page
     * @return returns integer value of how many elements were found on page
     */
    public int countElements(By locator) {
        return driver.findElements(locator).size();
    }

    /**
     * Pick random item from list of elements
     * Usable for different dropdowns for better coverage
     * @param locator is a 'By' locator of element on web-page
     */
    public void pickRandomItemFromTable(By locator) {
        List<WebElement> itemsInDropdown = driver.findElements(locator);
        int listSize = itemsInDropdown.size();
        int randNumber = ThreadLocalRandom.current().nextInt(0, listSize);
        WebElement toClick = itemsInDropdown.get(randNumber);
        toClick.click();
    }

    /**
     * Method takes list of collected web-elements, creates list of their values, deletes empty values
     * and compares those two lists.
     * Usable in cases when there is a need to check if all values are presented in the web-table.
     * @param locator is a 'By' locator of element on web-page
     * @param listForResults is a list of picked values of web-elements
     */
    public void compareListsSize(By locator, List<String> listForResults) {
        List<WebElement> list1 = driver.findElements(locator);
        int sizeOfValues = list1.size();
        int count = 0;
        while (count < sizeOfValues) {
            String text = list1.get(count).getText();
            listForResults.add(text);
            count++;
        }
        listForResults.removeIf(String::isBlank);
        Assert.assertEquals(list1.size(), listForResults.size());

    }

    /**
     * Method checks if downloaded file presents in set-up directory and deletes it if it has been found
     * @param fileName defines name of the file that should be downloaded
     * @param downloadPath defines path that will be used for file download
     * @return returns boolean value: true if requested file present and false if not
     */
    @SuppressWarnings("UnusedReturnValue")
    public boolean checkFileIsDownloaded(String fileName, String downloadPath) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        assert dirContents != null;
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                dirContent.deleteOnExit();
                return true;
            }
        }
        return false;
    }

//____________________________________________________Sending Keys______________________________________________________

    /**
     * Send text to web-element
     * @param locator is a 'By' locator of element on web-page
     * @param text is a text that will be sent to web-element
     */
    public void sendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Send text to web-element and press TAB Button
     * @param locator is a 'By' locator of element on web-page
     * @param text is a text that will be sent to web-element
     */
    public void inputTextAndPressTab(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        driver.findElement(locator).sendKeys(Keys.TAB);

    }

    /**
     * Method sends text to multiple elements on page.
     * It can be used to fill all inputs on page with sample text.
     * @param locator is a 'By' locator of element on web-page
     * @param text is a text that will be sent to web-element
     */
    public void sendTextToMultipleElements(By locator, String text) {
        List<WebElement> addresses = driver.findElements(locator);
        int numberOfInputs = addresses.size();
        int iteration = 0;
        while (iteration != numberOfInputs) {
            driver.findElements(locator).get(iteration).sendKeys(text);
            iteration++;
        }
    }

//_______________________________________________________Clicks_________________________________________________________

    /**
     * Click web-element on page
     * @param locator is a 'By' locator of element on web-page
     */
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Click element from list by id of the element
     * @param locator is a 'By' locator of element on web-page
     * @param id is an id of element from all elements from list
     */
    public void clickElementById(By locator, int id) {
        driver.findElements(locator).get(id).click();
    }

    /**
     * Click element using java-script
     * Can be used when it is not possible/necessary to emulate human-like behavior
     * Will click through other elements without interception
     * @param locator is a 'By' locator of element on web-page
     */
    public void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", element);
    }

    /**
     * Click all element that will be collected with locator
     * Can be used to click all clickable elements on page.
     * @param locator is a 'By' locator of element on web-page
     */
    @SuppressWarnings("unused")
    public void clickMultipleElements(By locator) {
        List<WebElement> addresses = driver.findElements(locator);
        int numberOfElements = addresses.size();
        int iteration = 0;
        while (iteration != numberOfElements) {
            driver.findElements(locator).get(iteration).click();
            iteration++;
        }
    }

    /**
     * Click all element that will be collected with locator with java-script.
     * Can be used to click all clickable elements on page.
     * @param locator is a 'By' locator of element on web-page
     */
    public void jsClickMultipleElements(By locator) {
        List<WebElement> addresses = driver.findElements(locator);
        int numberOfElements = addresses.size();
        int iteration = 0;
        while (iteration != numberOfElements) {
            WebElement toClick = driver.findElements(locator).get(iteration);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", toClick);
            iteration++;
        }
    }

//_______________________________________________________Actions________________________________________________________

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    public void scrollDownPage(int deltaX, int deltaY) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(deltaX, deltaY).perform();
    }

    public void actionClick(By locator) {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(locator));
    }

    public void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(locator));
    }

    public void contextClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator));
    }

    public void clickAndHold(By locator) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(locator));
    }

    public void dragAndDropElementByCoordinates(By locator, int xAxes, int yAxes) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(locator), xAxes, yAxes);
    }

    public void dragAndDropElementToElement(By locatorFrom, By locatorTo) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(locatorFrom), driver.findElement(locatorTo));
    }
//_______________________________________________________Alerts_________________________________________________________

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void getAlertText() {
        driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
//______________________________________________________Switches________________________________________________________
    public void switchToNewWindow() {
        String newTab = driver.getWindowHandle();
        driver.switchTo().window(newTab);
    }

    public void switchToOriginalWindow(String origin) {
        driver.switchTo().window(origin);
    }

    public void switchBetweenFrames(By locator) {
        WebElement newFrame = driver.findElement(locator);
        driver.switchTo().frame(newFrame);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

}
