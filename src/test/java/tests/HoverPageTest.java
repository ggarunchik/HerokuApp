package tests;

import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverPageTest extends BaseTest {

    @Test
    public void verifyFirstProfile() {
        HoverPage hoverPage = new HoverPage(driver);
        hoverPage
                .openHoverPage()
                .hoverOverFirstProfile();
    }

    @Test
    public void verifySecondProfile() {
        HoverPage hoverPage = new HoverPage(driver);
        hoverPage
                .openHoverPage()
                .hoverOverSecondProfile();
    }

    @Test
    public void verifyThirdProfile() {
        HoverPage hoverPage = new HoverPage(driver);
        hoverPage
                .openHoverPage()
                .hoverOverThirdProfile();
    }
}
