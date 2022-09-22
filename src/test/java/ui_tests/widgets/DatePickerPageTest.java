package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.DATE_PICKER_PAGE;

public class DatePickerPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(DATE_PICKER_PAGE);
    }

    @Test
    public void pickDateOnFirstPicker(){
        datePickerPage.pickDate();
    }

    @Test
    public void pickDateFromSecondPicker() {
        datePickerPage.pickDateSecondPicker();
    }
}
