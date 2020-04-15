package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxesPage extends BasePage {

    private static final String checkBoxPageUrl = "http://the-internet.herokuapp.com/checkboxes";

    private By firstCheckBox = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    private By secondCheckBox = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public CheckBoxesPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxesPage openCheckBoxPage() {
        driver.get(checkBoxPageUrl);
        return this;
    }

    public CheckBoxesPage isFirstCheckBoxSelected() {
        isCheckBoxChecked(firstCheckBox);
        return this;
    }

    public CheckBoxesPage isSecondCheckBoxSelected() {
        isCheckBoxChecked(secondCheckBox);
        return this;
    }

    public CheckBoxesPage isFirstCheckBoxNotSelected() {
        isCheckBoxNotChecked(firstCheckBox);
        return this;
    }

    public CheckBoxesPage isSecondCheckBoxNotSelected() {
        isCheckBoxNotChecked(secondCheckBox);
        return this;
    }

    public CheckBoxesPage selectFirstCheckBox() {
        click(firstCheckBox);
        return this;
    }

    public CheckBoxesPage checkSecondCheckBox() {
        click(secondCheckBox);
        return this;
    }
}
