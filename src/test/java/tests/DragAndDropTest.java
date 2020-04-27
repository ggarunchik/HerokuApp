package tests;

import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void verifyDragAndDrop() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage
                .openDragAndDropPage()
                .dragAndDropColumnHtml5("B")
                .verifyLastColumnName("A");
    }
}
