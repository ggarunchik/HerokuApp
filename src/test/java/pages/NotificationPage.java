package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NotificationPage extends BasePage {

    private static final String notificationPageUrl = "http://the-internet.herokuapp.com/notification_message_rendered";

    private By clickHereBtn = By.xpath("//*[@id=\"content\"]/div/p/a");
    private By alertMessage = By.xpath("//*[@id=\"flash\"]");

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public NotificationPage openNotificationPage() {
        driver.get(notificationPageUrl);
        return this;
    }

    public NotificationPage verifySuccessAlert() {
        click(clickHereBtn);
        WebElement jsAlertMsg = driver.findElement(alertMessage);
        String value = ((JavascriptExecutor) driver).executeScript("return arguments[0].firstChild.textContent", jsAlertMsg).toString();
        value = value.replace("\n", "").replace("\r", "").trim();

        if (!value.equals("Action successful")) {
            verifySuccessAlert();
        } else Assert.assertEquals(value, "Action successful");
        return this;
    }

    public NotificationPage verifyUnSuccessAlert() {
        click(clickHereBtn);
        WebElement jsAlertMsg = driver.findElement(alertMessage);
        String value = ((JavascriptExecutor) driver).executeScript("return arguments[0].firstChild.textContent", jsAlertMsg).toString();
        value = value.replace("\n", "").replace("\r", "").trim();

        if (!value.equals("Action unsuccesful, please try again")) {
            verifySuccessAlert();
        } else Assert.assertEquals(value, "Action unsuccesful, please try again");
        return this;
    }


}
