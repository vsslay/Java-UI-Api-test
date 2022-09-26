package pages.interactions_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

@SuppressWarnings("UnusedReturnValue")
public class DraggablePage extends BasePage {
    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    public final By axisRestriction = By.id("draggableExample-tab-axisRestriction");
    public final By containerRestriction = By.id("draggableExample-tab-containerRestriction");
    public final By cursorStyle = By.id("draggableExample-tab-cursorStyle");
    public final By dragSimple = By.id("draggableExample-tab-simple");
    public final By yRestricted = By.id("restrictedY");
    public final By xRestricted = By.id("restrictedX");
    public final By inBox = By.xpath("//*[contains(text(),'contained within the box')]");
    public final By withinParent = By.xpath("//*[contains(text(),'contained within my parent')]");
    public final By cursorCenter = By.id("cursorCenter");
    public final By cursorTopLeft = By.id("cursorTopLeft");
    public final By cursorBottom = By.id("cursorBottom");
    public final By dragBox = By.id("dragBox");

    public DraggablePage checkAxisRestrictedTab() {
        clickElement(axisRestriction);
        waitElementIsClickable(yRestricted);
        waitElementIsVisible(xRestricted);
        dragAndDropElementByCoordinates(yRestricted, 0, 100);
        dragAndDropElementByCoordinates(xRestricted, 100, 0);
        return this;
    }

    public DraggablePage checkContainerRestrictedTab() {
        clickElement(containerRestriction);
        waitElementIsVisible(withinParent);
        waitElementIsVisible(inBox);
        dragAndDropElementByCoordinates(inBox, 50, 50);
        dragAndDropElementByCoordinates(withinParent, 50, 50);
        return this;
    }

    public DraggablePage checkCursorStyleTab() {
        clickElement(cursorStyle);
        waitElementIsVisible(cursorStyle);
        waitElementIsVisible(cursorBottom);
        waitElementIsVisible(cursorCenter);
        dragAndDropElementToElement(cursorTopLeft, cursorBottom);
        dragAndDropElementToElement(cursorBottom, cursorCenter);
        dragAndDropElementToElement(cursorCenter, cursorTopLeft);
        return this;
    }

    public DraggablePage checkSimplePage() {
        clickElement(dragSimple);
        dragAndDropElementToElement(dragBox, dragBox);
        return this;
    }
}
