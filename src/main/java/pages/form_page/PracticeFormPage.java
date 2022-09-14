package pages.form_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base_page.BasePage;

import java.util.ArrayList;
import java.util.List;

import static constants.constant.Paths.UPLOAD_FOLDER_PATH;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By eMail = By.id("userEmail");
    private final By mobileNumber = By.id("userNumber");
    private final By userSubjects = By.xpath("//div[@id='subjectsContainer']//input");
    private final By uploadPicture = By.id("uploadPicture");
    private final By currentAddress = By.id("currentAddress");
    private final By genderWrapper = By.xpath("//div[@id='genterWrapper']//input");
    private final By genderChoice = By.xpath("//div[@class='custom-control " +
                                                        "custom-radio custom-control-inline']");
    private final By hobbiesChoice = By.xpath("//div[@class='custom-control " +
                                                        "custom-checkbox custom-control-inline']");
    private final By submitButton = By.xpath("//button[@id='submit']");

    private final By datePicker = By.id("dateOfBirthInput");
    private final By monthPicker = By.xpath("//div/select/*");
    private final By yearPicker = By.xpath("//div/select[1]/*");
    private final By dayPicker = By.xpath("//div[@role='listbox']");
    private final By statePicker = By.xpath("//*[@id='state']//input");
    private final By cityPicker = By.xpath("//*[@id='city']//input");
    private final By finalModal = By.xpath("//div[@class='fade modal show']");
    private final By valuesTable = By.xpath("//tr/td[2]");

    public PracticeFormPage inputFormData() {
        sendKeys(firstName, "Andrew");
        sendKeys(lastName,"QaTest");
        sendKeys(eMail, "abc123@mail.com");
        sendKeys(mobileNumber, "9876543210");
        inputTextAndPressTab(userSubjects, "Mat");
        sendKeys(uploadPicture, UPLOAD_FOLDER_PATH);
        sendKeys(currentAddress, "Washington DC, Linkoln str.\n block A, apt. 987");
        inputTextAndPressTab(statePicker,"NCR");
        inputTextAndPressTab(cityPicker,"Delhi");
        clickElementById(genderChoice, 1);
        clickElementById(hobbiesChoice,0);
        clickElementById(hobbiesChoice, 1);
        clickElementById(hobbiesChoice, 2);
        clickElementById(hobbiesChoice, 1);

        return this;
    }
    @SuppressWarnings("UnusedReturnValue")
    public PracticeFormPage countGenders() {
        int countGender = countElements(genderWrapper);
        Assert.assertEquals(countGender, 3);

        return this;
    }

    public PracticeFormPage pickDate() {
        clickElement(datePicker);
        pickRandomItemFromTable(monthPicker);
        pickRandomItemFromTable(yearPicker);
        pickRandomItemFromTable(dayPicker);

        return this;
    }

    public PracticeFormPage clickSubmitButton() {
        jsClick(submitButton);

        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public PracticeFormPage checkTableHasAllValues() {
        waitElementIsVisible(finalModal);
        List<String> listOfValuesGot = new ArrayList<>();
        compareListsSize(valuesTable, listOfValuesGot);

        return this;
    }

}
