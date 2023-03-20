package com.utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils {
	
	public void elememtSelectbyIndex(WebDriver driver,WebElement element,int value)
	{
		
		try {
			Select sel=new Select(element);
			sel.selectByIndex(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void elememtSelectbyValue(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void elememtSelectbyVisibleText(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.selectByVisibleText(value);
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
	
	public void multielememtgetAllSelect(WebDriver driver,WebElement element)
	{
		
		try {
			Select sel=new Select(element);
			sel.getAllSelectedOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
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
	
	public void multielememtdeSelectByValue(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void multielememtDeSelectbyIndex(WebDriver driver,WebElement element,int value)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectByIndex(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void multielememtDeSelectbyVisibleText(WebDriver driver,WebElement element,String value)
	{
		
		try {
			Select sel=new Select(element);
			sel.deselectByVisibleText(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
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
