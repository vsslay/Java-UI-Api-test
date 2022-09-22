package ui_tests.widgets;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.constant.Urls.SLIDER_PAGE;

public class SliderPageTest extends BaseTest {

    @BeforeTest
    public void navigate() {
        basePage.open(SLIDER_PAGE);
    }

    @Test
    public void checkSlider() {
        sliderPage.dragSlider();
    }
}
