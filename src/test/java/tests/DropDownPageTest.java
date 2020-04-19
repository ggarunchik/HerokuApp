package tests;

import org.testng.annotations.Test;
import pages.DropDownPage;

import java.util.ArrayList;
import java.util.List;

public class DropDownPageTest extends BaseTest {

    private final List<String> optionsList = new ArrayList<>();

    @Test
    public void verifyDropDownMenu() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.initOptionsList(optionsList);
        dropDownPage
                .openDropDownPage()
                .verifyDropDownOptions(optionsList)
                .selectDropDownOption("Option 1")
                .isDropDownOptionSelected("Option 1")
                .selectDropDownOption("Option 2")
                .isDropDownOptionSelected("Option 2");
    }
}
