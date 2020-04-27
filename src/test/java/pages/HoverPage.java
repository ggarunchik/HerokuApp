package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.HttpResponseValidator;

public class HoverPage extends BasePage {

    private static final String hoverPageUrl = "http://the-internet.herokuapp.com/hovers";

    private By firstAvatar = By.xpath("//*[@id=\"content\"]/div/div[1]");
    private By firstAvatarInfo = By.xpath("//*[@id=\"content\"]/div/div[1]/div/a");
    private By secondAvatar = By.xpath("//*[@id=\"content\"]/div/div[2]");
    private By secondAvatarInfo = By.xpath("//*[@id=\"content\"]/div/div[2]/div/a");
    private By thirdAvatar = By.xpath("//*[@id=\"content\"]/div/div[3]");
    private By thirdAvatarInfo = By.xpath("//*[@id=\"content\"]/div/div[3]/div/a");

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public HoverPage openHoverPage() {
        driver.get(hoverPageUrl);
        return this;
    }

    public HoverPage hoverOverFirstProfile() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(firstAvatar)).moveToElement((driver.findElement(firstAvatarInfo))).click().build().perform();
        String currentUrl = driver.getCurrentUrl();
        int statusCode = HttpResponseValidator.httpResponseCodeViaGet(currentUrl);
        assertEquals(statusCode, 404);
        return this;
    }

    public HoverPage hoverOverSecondProfile() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(secondAvatar)).moveToElement((driver.findElement(secondAvatarInfo))).click().build().perform();
        String currentUrl = driver.getCurrentUrl();
        int statusCode = HttpResponseValidator.httpResponseCodeViaGet(currentUrl);
        assertEquals(statusCode, 404);
        return this;
    }

    public HoverPage hoverOverThirdProfile() {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(thirdAvatar)).moveToElement((driver.findElement(thirdAvatarInfo))).click().build().perform();
        String currentUrl = driver.getCurrentUrl();
        int statusCode = HttpResponseValidator.httpResponseCodeViaGet(currentUrl);
        assertEquals(statusCode, 404);
        return this;
    }
}

