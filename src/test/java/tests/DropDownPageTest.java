package tests;

import org.testng.annotations.Test;
import pages.DropDownPage;

public class DropDownPageTest extends BaseTest {

    @Test
    public void verifyDropDownMenu() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage
                .openDropDownPage()
                .verifyDropDownOptions()
                .selectDropDownOption("Option 1")
                .isDropDownOptionSelected("Option 1")
                .selectDropDownOption("Option 2")
                .isDropDownOptionSelected("Option 2");
    }
}
