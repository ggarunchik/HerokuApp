package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePage{

    private static final String JS_ALERT_PAGE_URL = "http://the-internet.herokuapp.com/javascript_alerts";

    private static final By JS_ALERT_LOCATOR = By.xpath("//*/button[@onclick='jsAlert()']");
    private static final By JS_CONFIRM_LOCATOR = By.xpath("//*/button[@onclick='jsConfirm()']");
    private static final By JS_PROMPT_LOCATOR = By.xpath("//*/button[@onclick='jsPrompt()']");
    private static final By JS_RESULT_LOCATOR = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    public JavaScriptAlertsPage openJSAlertPage() {
        driver.get(JS_ALERT_PAGE_URL);
        return this;
    }

    public JavaScriptAlertsPage verifyJSAlert(String resultText) {
        click(JS_ALERT_LOCATOR);
        verifyAlertText("I am a JS Alert", "accept");
        assertEquals(driver.findElement(JS_RESULT_LOCATOR).getText(), resultText);
        return this;
    }

    public JavaScriptAlertsPage verifyJSConfirmAlert(String resultText) {
        click(JS_CONFIRM_LOCATOR);
        verifyAlertText("I am a JS Confirm", "accept");
        assertEquals(driver.findElement(JS_RESULT_LOCATOR).getText(), resultText);
        return this;
    }

    public JavaScriptAlertsPage verifyJSDismissAlert(String resultText) {
        click(JS_CONFIRM_LOCATOR);
        verifyAlertText("I am a JS Confirm", "dismiss");
        assertEquals(driver.findElement(JS_RESULT_LOCATOR).getText(), resultText);
        return this;
    }

    public JavaScriptAlertsPage verifyJSPromptAlert(String alertInputText) {
        click(JS_PROMPT_LOCATOR);
        enterAlertPromptMessage(alertInputText);
        verifyAlertText("I am a JS prompt", "accept");
        assertEquals(driver.findElement(JS_RESULT_LOCATOR).getText(), "You entered: " + alertInputText);
        return this;
    }

}
