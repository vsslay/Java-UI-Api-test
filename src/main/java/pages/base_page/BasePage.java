package pages.base_page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    /**
     *
     * @param locator defines element to take text from
     * @return text of element
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public String getElementText(By locator) {
        String text = driver.findElement(locator).getText();
        return text;
    }

    /**
     * Get attribute value of defined element on page
     * @param locator defines locator of element that contains attribute needed
     * @param name is a name of attribute that had to be got
     * @return value of attribute via String format
     */
    public String getElementAttribute(By locator, String name) {
        @SuppressWarnings("UnnecessaryLocalVariable")
        String attribute = driver.findElement(locator).getAttribute(name);
        return attribute;
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

    /**
     * Get text of element from list by id of the element
     * @param locator is a 'By' locator of element on web-page
     * @param id is an id of element from all elements from list
     */
    public String getTextById(By locator, int id) {
        @SuppressWarnings("UnnecessaryLocalVariable")
        String text = driver.findElements(locator).get(id).getText();
        return text;
    }

//____________________________________________________Sending Keys______________________________________________________

    /**
     * Send keys to element from list by id of the element
     * @param locator is a 'By' locator of element on web-page
     * @param id is an id of element from all elements from list
     */
    public void sendKeysById(By locator, int id, String text) {
        driver.findElements(locator).get(id).sendKeys(text);
    }

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

    /**
     * Hold defined key until statement is equal
     */
    public void holdKey(By locator, Keys key) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(key);
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
     *
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public Object getElementAttributes(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Object attributes = jse.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", element);
        return attributes;
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

    /**
     * Scrolls to element on page
     * @param element defines element to be scrolled to
     */
    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    /**
     * scrolling page by X and Y axes
     * @param deltaX defines X-axes
     * @param deltaY defines Y-axes
     */
    public void scrollDownPage(int deltaX, int deltaY) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(deltaX, deltaY).perform();
    }

    /**
     * Click element on page using Actions
     * @param locator defines element to be clicked
     */
    public void actionClick(By locator) {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(locator));
    }

    /**
     * Double click element on page
     * @param locator defines element to be double-clicked
     */
    public void doubleClick(By locator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(locator));
    }

    /**
     * Right click element on page
     * @param locator defines element to be right-clicked
     */
    public void contextClick(By locator) {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator));
    }

    /**
     * Click and hold element on page
     * @param locator defines element to be clicked and held
     */
    public void clickAndHold(By locator) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(locator));
    }

    /**
     * Drag and drop element by coordinates
     * @param locator element to be drag&drop
     * @param xAxes drag and drop X-axes
     * @param yAxes drag and drop Y-axes
     */
    public void dragAndDropElementByCoordinates(By locator, int xAxes, int yAxes) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(locator), xAxes, yAxes);
    }

    /**
     * Drag element and drop it to another element
     * @param locatorFrom element that will be dragged
     * @param locatorTo element to drop first element on
     */
    public void dragAndDropElementToElement(By locatorFrom, By locatorTo) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(locatorFrom), driver.findElement(locatorTo));
    }

    /**
     * Move cursor to the element
     * @param locator defines the element to focuse on
     */
    public void focusOnElement(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }
//_______________________________________________________Alerts_________________________________________________________

    /**
     * Dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * Accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * Get text from alert
     */
    public void getAlertText() {
        driver.switchTo().alert().getText();
    }

    /**
     * Send text to alert
     * @param text defines text to be sent to alert
     */
    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

//______________________________________________________Switches________________________________________________________

    /**
     * Switch driver to work with new window
     */
    public void switchToNewWindow() {
        String newTab = driver.getWindowHandle();
        driver.switchTo().window(newTab);
    }

    /**
     * Return to original window
     * @param origin handle for original window
     */
    public void switchToOriginalWindow(String origin) {
        driver.switchTo().window(origin);
    }

    /**
     * Switch to defined iframe on page
     * @param locator defines iframe to be switched to
     */
    public void switchBetweenFrames(By locator) {
        WebElement newFrame = driver.findElement(locator);
        driver.switchTo().frame(newFrame);
    }

    /**
     * Switch back to parent iframe
     */
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

//______________________________________________________Selects_________________________________________________________

    public void selectByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public void selectByIndex(By locator, Integer index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void selectByVisibleText(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }

    public void deselectByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.deselectByValue(value);
    }

    public void deselectByIndex(By locator, Integer index) {
        Select select = new Select(driver.findElement(locator));
        select.deselectByIndex(index);
    }

    public void deselectByVisibleText(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.deselectByVisibleText(value);
    }

    public void deselectByVisibleText(By locator) {
        Select select = new Select(driver.findElement(locator));
        select.deselectAll();
    }
}
