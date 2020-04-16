package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputPage extends BasePage {

    private static final String inputPageUrl = "http://the-internet.herokuapp.com/inputs";

    By inputField = By.xpath("//*[@id=\"content\"]/div/div/div/input");

    public InputPage(WebDriver driver) {
        super(driver);
    }

    public InputPage openInputPage() {
        driver.get(inputPageUrl);
        return this;
    }

    public InputPage changeInputNumberUp(int clickNumber) {
        for (int i = 0; i < clickNumber; i++) {
            driver.findElement(inputField).sendKeys(Keys.ARROW_UP);
        }
        int inputValue = Integer.parseInt(driver.findElement(inputField).getAttribute("value"));
        assertIntValuesEquals(inputValue, clickNumber);
        return this;
    }

    public InputPage changeInputNumberDown(int clickNumber) {
        for (int i = 0; i < clickNumber; i++) {
            driver.findElement(inputField).sendKeys(Keys.ARROW_DOWN);
        }
        int inputValue = Integer.parseInt(driver.findElement(inputField).getAttribute("value"));
        assertIntValuesEquals(inputValue, clickNumber * -1);
        return this;
    }

}
