package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ElementsPage extends BasePage {

    private static final String elementsPageUrl = "http://the-internet.herokuapp.com/add_remove_elements/";

    private By addElementBtn = By.xpath("//button[text()='Add Element']");
    private By deleteElementBtn = By.xpath("//button[text()='Delete']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public ElementsPage openElementsPage() {
        driver.get(elementsPageUrl);
        return this;
    }

    public ElementsPage addMultiplyElements(int amountOfElements) {
        for (int i = 0; i < amountOfElements; i++) {
            click(addElementBtn);
        }
        return this;
    }

    public ElementsPage deleteLastElement() {
        List<WebElement> createdElements = driver.findElements(By.className("added-manually"));
        int lastElement = createdElements.size() - 1;
        driver.findElements(By.className("added-manually")).get(lastElement).click();
        return this;
    }

    public ElementsPage verifyElementsAmount(int expectedAmount) {
        int numOfElements = driver.findElements(By.className("added-manually")).size();
        assertIntValuesEquals(numOfElements, expectedAmount);
        return this;
    }
}
