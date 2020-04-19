package tests;

import org.testng.annotations.Test;
import pages.CheckBoxesPage;

public class CheckBoxesTest extends BaseTest {

    @Test
    public void verifyFirstCheckBox() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage
                .openCheckBoxPage()
                .isFirstCheckBoxNotSelected()
                .selectFirstCheckBox()
                .isFirstCheckBoxSelected();
    }

    @Test
    public void verifySecondCheckBox() {
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage
                .openCheckBoxPage()
                .isSecondCheckBoxSelected()
                .selectSecondCheckBox()
                .isSecondCheckBoxNotSelected();
    }


}
