package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Select select;
    Alert alert;
    Actions actions;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(this.driver);
    }

    public void waitForElementVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click(By elementBy) {
        waitForElementVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void writeText(By elementBy, String text) {
        waitForElementVisibility(elementBy);
        clearField(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy) {
        waitForElementVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertEquals(By elementBy, String expectedText) {
        waitForElementVisibility(elementBy);
        Assert.assertEquals(driver.findElement(elementBy).getAttribute("value"), expectedText);
    }

    public void assertEquals(int firstValue, int secondValue) {
        Assert.assertEquals(firstValue, secondValue, "Values are not equals");
    }

    public void assertEquals(String firstValue, String secondValue) {
        Assert.assertEquals(firstValue, secondValue, "Values are not equals");
    }

    public void selectFromDropDown(By elementBy, String textToSelect) {
        select = new Select(driver.findElement(elementBy));
        select.selectByVisibleText(textToSelect);
    }

    public void clearField(By elementBy) {
        driver.findElement(elementBy).clear();
    }

    /**
     * @param expectedAlertText type expected text in JS alert
     * @param action            type "accept" to accept JS alert / "dismiss to dismiss JS alert / "null"
     */
    public void verifyAlertText(String expectedAlertText, String action) {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedAlertText);
        switch (action) {
            case ("accept"):
                alert.accept();
                break;
            case ("dismiss"):
                alert.dismiss();
                break;
            default:
                break;
        }
    }

    public void enterAlertPromptMessage(String alertPromptMessage) {
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.sendKeys(alertPromptMessage);
    }

    public void isCheckBoxSelected(By elementBy) {
        Assert.assertTrue(driver.findElement(elementBy).isSelected());
    }

    public void isCheckBoxNotSelected(By elementBy) {
        Assert.assertFalse(driver.findElement(elementBy).isSelected());
    }

    public void navigateBack() {
        driver.navigate().back();
    }
}
