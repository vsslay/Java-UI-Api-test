package pages.elements_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPage extends BasePage {
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    private final By dropBoxExpansion = By.xpath("//button[contains(@title,'Expand')]");
    private final By checkBoxes = By.xpath("//span[@class='rct-text']//label/span[1]");
    private final By resultValuesList = By.xpath("//span[@class='text-success']");

    public CheckBoxPage clickAllCheckboxes() {
        waitElementIsVisible(dropBoxExpansion);
        clickElement(dropBoxExpansion);
        jsClickMultipleElements(checkBoxes);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public CheckBoxPage checkResult() {
        List<String> listOfValuesGot = new ArrayList<>();
        compareListsSize(resultValuesList, listOfValuesGot);
        return this;
    }
}
