import java.awt.Robot;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RobotActionCls {
	WebDriver driver = new EdgeDriver();
	
	/*driver.get("http://webdriveruniversity.com/File-Upload/index.html");
	
	Thread.sleep(2000);
	
	WebElement uploadBtn = driver.findElement(By.id("myFile"));
	uploadBtn.click();
	
	
	Robot robot = new Robot(); 
	
	 String path = "C:\\Users\\HP\\Desktop\\SS\\NewSchema.txt";
	 
       StringSelection stringSelection = new StringSelection(path);
       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
       clipboard.setContents(stringSelection, stringSelection); 
       
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       
       robot.keyPress(KeyEvent.VK_ENTER);

       robot.keyRelease(KeyEvent.VK_ENTER);*/

}
