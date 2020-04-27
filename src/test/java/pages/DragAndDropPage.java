package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class DragAndDropPage extends BasePage {


    private static final String DRAG_AND_DROP_URL = "http://the-internet.herokuapp.com/drag_and_drop";

    private static final By COLUMN_A_LOCATOR = By.xpath("//*/header[contains(text(),'A')]/..");
    private static final By COLUMN_OVER_A_LOCATOR = By.id("column-a");
    private static final By COLUMN_B_LOCATOR = By.xpath("//*/header[contains(text(),'B')]/..");
    private static final By COLUMN_OVER_B_LOCATOR = By.className("column over");
    private static final By COLUMNS_LOCATOR = By.className("column");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage openDragAndDropPage() {
        driver.get(DRAG_AND_DROP_URL);
        return this;
    }

    /**
     * @param columnName "A" or "B"
     * @return
     */
    public DragAndDropPage dragAndDropColumn(String columnName) {
        switch (columnName) {
            case ("B"):
                waitForElementVisibility(COLUMN_B_LOCATOR);
               // actions.clickAndHold(driver.findElement(COLUMN_B_LOCATOR)).moveToElement(driver.findElement(COLUMN_OVER_B_LOCATOR)).release().perform();
                actions.dragAndDrop(driver.findElement(COLUMN_B_LOCATOR), driver.findElement(COLUMN_A_LOCATOR)).build().perform();
                break;
            case ("A"):
                actions.dragAndDrop(driver.findElement(COLUMN_A_LOCATOR), driver.findElement(COLUMN_B_LOCATOR)).build().perform();
                break;
            default:
                System.out.println("smth went wrong dude");
                break;
        }
        return this;
    }

    public DragAndDropPage verifyLastColumnName(String expectedColumnName) {
        List<WebElement> columns = driver.findElements(COLUMNS_LOCATOR);
        String elementToVerify = columns.get(columns.size() - 1).getText();
        assertEquals(elementToVerify, expectedColumnName);
        return this;
    }
}
