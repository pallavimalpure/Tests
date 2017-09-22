package com.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.config.ConfigHelper;
import com.pageObjects.RetrieveQuotePageObjects;

public class KeyWords 
{
	WebDriver driver;
	RetrieveQuotePageObjects retObjects = new RetrieveQuotePageObjects(driver);
	
	public void sendKeys(WebDriver driver,String locatorPath,String sendText)
	{
		driver.findElement(By.xpath(locatorPath)).sendKeys(sendText);
	}
	
	public WebDriver loadBrowser(WebDriver driver)
	{
		String browserDriver = ConfigHelper.getConHelper().getBrowserDriver();
		String browserExe = ConfigHelper.getConHelper().getBrowserExe();
		
		System.setProperty(browserDriver, browserExe);
		if(browserDriver.equals("webdriver.chrome.driver"))
		{
			driver = new ChromeDriver();
		}
		else if(browserDriver.equals("webdriver.ie.driver"))
		{
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
}
