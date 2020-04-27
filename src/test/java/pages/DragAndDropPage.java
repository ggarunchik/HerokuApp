package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DragAndDropPage extends BasePage {


    private static final String DRAG_AND_DROP_URL = "http://the-internet.herokuapp.com/drag_and_drop";

    private static final By COLUMN_A_LOCATOR = By.id("column-a");
    private static final By COLUMN_B_LOCATOR = By.id("column-b");
    private static final By COLUMNS_LOCATOR = By.className("column");

    private static final String java_script =
            "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                    "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                    "ction(format,data){this.items[format]=data;this.types.append(for" +
                    "mat);},getData:function(format){return this.items[format];},clea" +
                    "rData:function(format){}};var emit=function(event,target){var ev" +
                    "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                    "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                    "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                    "'drop',tgt);emit('dragend',src);";

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage openDragAndDropPage() {
        driver.get(DRAG_AND_DROP_URL);
        return this;
    }

    /**
     * @param columnName "A" or "B"
     * @return
     */
    public DragAndDropPage dragAndDropColumnHtml5(String columnName) {
        switch (columnName) {
            case ("B"):
                ((JavascriptExecutor)driver).executeScript(java_script, driver.findElement(COLUMN_B_LOCATOR), driver.findElement(COLUMN_A_LOCATOR));
                break;
            case ("A"):
                ((JavascriptExecutor)driver).executeScript(java_script, driver.findElement(COLUMN_A_LOCATOR), driver.findElement(COLUMN_B_LOCATOR));
                break;
            default:
                System.out.println("smth went wrong dude");
                break;
        }
        return this;
    }

    public DragAndDropPage verifyLastColumnName(String expectedColumnName) {
        List<WebElement> columns = driver.findElements(COLUMNS_LOCATOR);
        String elementToVerify = columns.get(columns.size() - 1).getText();
        assertEquals(elementToVerify, expectedColumnName);
        return this;
    }
}
