package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage extends BasePage {

    private static final String dropDownPageUrl = "http://the-internet.herokuapp.com/dropdown";
    private By dropDownMenu = By.xpath("//*[@id=\"dropdown\"]");

    private final List<String> optionsList = new ArrayList<>();


    public DropDownPage(WebDriver driver) {
        super(driver);
        initOptionsList();
    }

    private void initOptionsList() {
        optionsList.add("Please select an option");
        optionsList.add("Option 1");
        optionsList.add("Option 2");
    }

    public DropDownPage openDropDownPage() {
        driver.get(dropDownPageUrl);
        return this;
    }

    public DropDownPage verifyDropDownOptions() {
        select = new Select(driver.findElement(dropDownMenu));
        List<WebElement> optionsElements = select.getOptions();
        for (int i = 0; i < optionsElements.size(); i++) {
            Assert.assertEquals(select.getOptions().get(i).getText(), optionsList.get(i));
        }
        return this;
    }

    public DropDownPage selectDropDownOption(String optionToSelect) {
        selectFromDropDown(dropDownMenu, optionToSelect);
        return this;
    }

    public DropDownPage isDropDownOptionSelected(String optionToSelect) {
        select = new Select(driver.findElement(dropDownMenu));
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, optionToSelect);
        return this;
    }

}
