package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploaderPage extends BasePage {

    private static final String FILE_UPLOADER_URL = "http://the-internet.herokuapp.com/upload";

    private static final By SELECT_DOWNLOAD_FILE_BTN = By.id("file-upload");
    private static final By UPLOAD_BTN = By.id("file-submit");
    private static final By FILE_UPLOADED_TEXT_LOCATOR = By.xpath("//*/h3[contains(text(), 'File Uploaded!')]");
    private static final By UPLOADED_FILE_NAME_LOCATOR = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    public FileUploaderPage openFileUploadPage() {
        driver.get(FILE_UPLOADER_URL);
        return this;
    }

    public FileUploaderPage uploadFileByURL(String downloadFileURL) {
        driver.findElement(SELECT_DOWNLOAD_FILE_BTN).sendKeys(downloadFileURL);
        click(UPLOAD_BTN);
        waitForElementVisibility(FILE_UPLOADED_TEXT_LOCATOR);
        return this;
    }

    public FileUploaderPage verifyUploadedFileName(String uploadedFileName) {
        assertEquals(readText(UPLOADED_FILE_NAME_LOCATOR), uploadedFileName);
        return this;
    }
}
