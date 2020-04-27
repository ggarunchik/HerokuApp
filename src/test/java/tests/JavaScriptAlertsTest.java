package tests;

import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    public void verifyJSAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage
                .openJSAlertPage()
                .verifyJSAlert("You successfuly clicked an alert");
    }

    @Test
    public void verifyJSConfirmAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage
                .openJSAlertPage()
                .verifyJSConfirmAlert("You clicked: Ok")
                .verifyJSDismissAlert("You clicked: Cancel");
    }

    @Test
    public void verifyJSPromptAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
        javaScriptAlertsPage
                .openJSAlertPage()
                .verifyJSPromptAlert("Dima if u read this msg - contact me");
    }
}
