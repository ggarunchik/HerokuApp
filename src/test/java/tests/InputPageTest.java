package tests;

import org.testng.annotations.Test;
import pages.InputPage;

public class InputPageTest extends BaseTest {

    @Test
    public void verifyNumberChangeUp(){
        InputPage inputPage = new InputPage(driver);
        inputPage
                .openInputPage()
                .changeInputNumberUp(56);
    }

    @Test
    public void verifyNumberChangeDown(){
        InputPage inputPage = new InputPage(driver);
        inputPage
                .openInputPage()
                .changeInputNumberDown(42);
    }
}
