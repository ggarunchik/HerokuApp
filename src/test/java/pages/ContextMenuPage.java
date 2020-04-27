package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    private static final String CONTEXT_MENU_PAGE_URL = "http://the-internet.herokuapp.com/context_menu";

    private static final By BORDER_LOCATOR = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public ContextMenuPage openContextPage() {
        driver.get(CONTEXT_MENU_PAGE_URL);
        return this;
    }

    public ContextMenuPage rightClickAndVerifyMessage(String messageToVerify) {
        actions.contextClick(driver.findElement(BORDER_LOCATOR)).build().perform();
        verifyAlertText(messageToVerify, "accept");
        return this;
    }
}
