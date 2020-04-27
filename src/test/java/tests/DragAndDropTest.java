package tests;

import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void verifyDragAndDrop() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage
                .openDragAndDropPage()
                .dragAndDropColumn("B")
                .verifyLastColumnName("A");
    }
}
