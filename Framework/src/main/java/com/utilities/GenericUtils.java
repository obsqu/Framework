package com.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {
	/**This method is for select the element by its index value
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	
	public void elememtSelectbyIndex(WebDriver driver,WebElement element,int index)
	{
		
		try {
			Select sel=new Select(element);
			sel.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method is for select the element by its  value
	 * @param driver
	 * @param element
	 * @param value
	 */
	
	public void elememtSelectbyValue(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void elememtSelectbyVisibleText(WebDriver driver,WebElement element,String text)
	{
		
		try {
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public List<WebElement> multielememtgetOption(WebDriver driver,WebElement element)
	{
		List<WebElement> list = null;
		
		try {
			Select sel=new Select(element);
			list=sel.getOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	/**This method is to get all selected elements
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */
	public List<WebElement> multielememtgetAllSelect(WebDriver driver,WebElement element)
	{
		List<WebElement> list = null;
		
		try {
			Select sel=new Select(element);
			list=sel.getAllSelectedOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	/**This method is to get the first option selected in the drop down
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */
	public String multielememtgetFirstSelectOption(WebDriver driver,WebElement element)
	{
		String firstOption = null;
		try {
			Select sel=new Select(element);
			firstOption=sel.getFirstSelectedOption().getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return firstOption;
	}
	
	/**This method is to deselect the elememts by value
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void multielememtDeSelectByValue(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**This method is to deselect the elememts by index
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void multielememtDeSelectbyIndex(WebDriver driver,WebElement element,int index)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**This method is to deselect the elememts by visible text
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void multielememtDeSelectbyVisibleText(WebDriver driver,WebElement element,String text)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**This method is to deselect all the elements
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 */
	public void multielememtDeSelectAll(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void dismissAnAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void acceptAnAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void getTitleOfAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

}
