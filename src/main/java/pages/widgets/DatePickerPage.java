package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class DatePickerPage extends BasePage {
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    public final By datePickerMonthYearInput = By.id("datePickerMonthYearInput");
    public final By datePickerMonthYearInputSecond = By.id("dateAndTimePickerInput");
    public final By monthPicker = By.xpath("//select[@class='react-datepicker__month-select']/option");
    public final By yearPicker = By.xpath("//select[@class='react-datepicker__year-select']/option");
    public final By dayPicker = By.xpath("//div[@class='react-datepicker__week']/div");
    public final By monthDropdown = By.xpath("//div[@class='react-datepicker__month-read-view']");
    public final By yearDropdown = By.xpath("//div[@class='react-datepicker__year-read-view']");
    public final By monthPickerSecondPicker =
            By.xpath("//div[@class='react-datepicker__month-dropdown']/div");
    public final By yearPickerSecondPicker =
            By.xpath("//div[@class='react-datepicker__year-dropdown']/div");
    public final By dayPickerSecondPicker =
            By.xpath("//div[@class='react-datepicker__week']/div");
    public final By timePicker = By.xpath("//ul[@class='react-datepicker__time-list']/li");

    @SuppressWarnings("UnusedReturnValue")
    public DatePickerPage pickDate() {
        clickElement(datePickerMonthYearInput);
        pickRandomItemFromTable(monthPicker);
        pickRandomItemFromTable(yearPicker);
        pickRandomItemFromTable(dayPicker);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public DatePickerPage pickDateSecondPicker() {
        clickElement(datePickerMonthYearInputSecond);
        clickElement(monthDropdown);
        pickRandomItemFromTable(monthPickerSecondPicker);
        clickElement(yearDropdown);
        pickRandomItemFromTable(yearPickerSecondPicker);
        pickRandomItemFromTable(dayPickerSecondPicker);
        pickRandomItemFromTable(timePicker);
        return this;
    }
}
