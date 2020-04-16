package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.HttpResponseValidator;

public class HoverPage extends BasePage {

    private static final String hoverPageUrl = "http://the-internet.herokuapp.com/hovers";

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public HoverPage openHoverPage() {
        driver.get(hoverPageUrl);
        return this;
    }

    public HoverPage hoverOverFirstProfile() {
        actions = new Actions(driver);
        actions.moveToElement(
                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]")))
                .moveToElement((driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"))))
                .click().build().perform();
        String currentUrl = driver.getCurrentUrl();
        int statusCode = HttpResponseValidator.httpResponseCodeViaGet(currentUrl);
        assertIntValuesEquals(statusCode, 404);
        return this;
    }

    public HoverPage hoverOverSecondProfile() {
        actions = new Actions(driver);
        actions.moveToElement(
                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]")))
                .moveToElement((driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"))))
                .click().build().perform();
        String currentUrl = driver.getCurrentUrl();
        int statusCode = HttpResponseValidator.httpResponseCodeViaGet(currentUrl);
        assertIntValuesEquals(statusCode, 404);
        return this;
    }

    public HoverPage hoverOverThirdProfile() {
        actions = new Actions(driver);
        actions.moveToElement(
                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]")))
                .moveToElement((driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"))))
                .click().build().perform();
        String currentUrl = driver.getCurrentUrl();
        int statusCode = HttpResponseValidator.httpResponseCodeViaGet(currentUrl);
        assertIntValuesEquals(statusCode, 404);
        return this;
    }
}

