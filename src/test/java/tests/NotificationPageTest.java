package tests;

import org.testng.annotations.Test;
import pages.NotificationPage;

public class NotificationPageTest extends BaseTest {

    @Test
    public void verifySuccessAlertMessage() {
        NotificationPage notificationPage = new NotificationPage(driver);
        notificationPage
                .openNotificationPage()
                .verifySuccessAlert();
    }

    @Test
    public void verifyUnSuccessAlertMessage() {
        NotificationPage notificationPage = new NotificationPage(driver);
        notificationPage
                .openNotificationPage()
                .verifyUnSuccessAlert();
    }
}
