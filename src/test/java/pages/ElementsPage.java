package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage extends BasePage {

    private static final String elementsPageUrl = "http://the-internet.herokuapp.com/add_remove_elements/";

    private By addElementBtn = By.xpath("//button[text()='Add Element']");
    private By deleteElementBtn = By.className("added-manually");

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

    public ElementsPage deleteElementByIndex(int elementIndex) {
        List<WebElement> createdElements = driver.findElements(deleteElementBtn);
        WebElement elementToDelete = createdElements.get(elementIndex);
        elementToDelete.click();
        return this;
    }

    public ElementsPage verifyElementsAmount(int expectedAmount) {
        int numOfElements = driver.findElements(By.className("added-manually")).size();
        assertEquals(numOfElements, expectedAmount);
        return this;
    }
}
