package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyGenerator;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        PropertyGenerator.initializeDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
