package tests;

import org.testng.annotations.Test;
import pages.FileUploaderPage;

import java.io.File;

public class FileUploaderTest extends BaseTest {

    private static final String UPLOAD_FILE_URL = "src/test/resources/fileToUpload.txt";
    private static final File UPLOAD_FILE_ABSOLUTE_URL = new File(UPLOAD_FILE_URL);

    @Test
    public void verifyUploadFile() {
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver);
        fileUploaderPage
                .openFileUploadPage()
                .uploadFileByURL(UPLOAD_FILE_ABSOLUTE_URL.getAbsolutePath())
                .verifyUploadedFileName("fileToUpload.txt");
    }
}
