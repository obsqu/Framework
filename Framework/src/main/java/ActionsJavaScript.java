

import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ActionsJavaScript {
	
	WebDriver driver= new EdgeDriver();
	//driver.get();
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	//System.out.println(js.executeScript("return document.URL;").toString());
	
	//System.out.println(js.executeScript("return document.title;").toString());
	
 
 

}
