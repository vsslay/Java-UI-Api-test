package pages.interactions_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

import java.util.Objects;

@SuppressWarnings({"SpellCheckingInspection", "UnusedReturnValue"})
public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public final By acceptDrop = By.id("droppableExample-tab-accept");
    public final By preventPropagationDrop = By.id("droppableExample-tab-preventPropogation");
    public final By revertibleDrop = By.id("droppableExample-tab-revertable");
    public final By simpleDrop = By.id("droppableExample-tab-simple");
    public final By acceptable = By.id("acceptable");
    public final By notAcceptable = By.id("notAcceptable");
    public final By droppable = By.id("droppable");
    public final By draggable = By.id("draggable");
    public final By dragBox = By.id("dragBox");
    public final By notGreedyDropBox = By.id("notGreedyDropBox");
    public final By notGreedyInnerDropBox = By.id("notGreedyInnerDropBox");
    public final By greedyDropBox = By.id("greedyDropBox");
    public final By greedyDropBoxInner = By.id("greedyDropBoxInner");
    public final By revertible = By.id("revertable");
    public final By notRevertible = By.id("notRevertable");
    public final By confirmDropped = By.xpath("//p[contains(text(),'Dropped!')]");

    public DroppablePage checkAcceptDropTab() {
        clickElement(acceptDrop);
        waitElementIsVisible(notAcceptable);
        waitElementIsVisible(acceptable);
        dragAndDropElementToElement(notAcceptable, droppable);
        checkTextPresentedOnPage("Drop here");
        dragAndDropElementToElement(acceptable, droppable);
        checkTextPresentedOnPage("Dropped!");
        return this;
    }

    public DroppablePage checkPropTab() {
        clickElement(preventPropagationDrop);
        waitElementIsVisible(dragBox);
        dragAndDropElementToElement(dragBox, greedyDropBoxInner);
        if (countElementsOnPage(confirmDropped)==1) {
            dragAndDropElementToElement(dragBox, greedyDropBox);
            if (countElementsOnPage(confirmDropped)==2) {
                dragAndDropElementToElement(dragBox, notGreedyInnerDropBox);
                if (countElementsOnPage(confirmDropped)==4) {
                    dragAndDropElementToElement(dragBox, notGreedyDropBox);
                }

            }
        }
        return this;
    }

    public DroppablePage checkRevertTab() {
        clickElement(revertibleDrop);
        waitElementIsVisible(revertible);
        waitElementIsVisible(notRevertible);
        dragAndDropElementToElement(revertible,droppable);
        if(Objects.equals(getElementAttribute(revertible, "style"),
                "position: relative; left: 0px; top: 0px;")) {
            dragAndDropElementToElement(notRevertible, droppable);
        }
        return this;
    }

    public DroppablePage checkSimpleTab() {
        clickElement(simpleDrop);
        waitElementIsVisible(draggable);
        dragAndDropElementToElement(draggable ,droppable);
        return this;
    }

}
