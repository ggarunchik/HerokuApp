package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;

public class ElementsTest extends BaseTest {

    @Test
    public void verifyElementsAmount() {
        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage
                .openElementsPage()
                .addMultiplyElements(2)
                .deleteLastElement()
                .verifyElementsAmount(1);
    }
}
