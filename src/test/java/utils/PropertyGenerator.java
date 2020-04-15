package utils;

public class PropertyGenerator {

    public static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }
}
