package tests;

import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends BaseTest {

    @Test
    public void verifyRightClick() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage
                .openContextPage()
                .rightClickAndVerifyMessage("You selected a context menu");
    }
}
