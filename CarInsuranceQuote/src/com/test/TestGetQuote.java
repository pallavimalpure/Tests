package com.test;

import org.testng.annotations.Test;

import com.config.ConfigHelper;
import com.keywords.KeyWords;
import com.pageObjects.RetrieveQuotePageObjects;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestGetQuote extends KeyWords 
{
	WebDriver driver;
	RetrieveQuotePageObjects retObjects = new RetrieveQuotePageObjects(driver);
	
  @Test
  public void getQuote() 
  {
	  //retObjects.firstName.sendKeys("testName");
	  try
	  {
		  driver.findElement(By.name("PrincipalPolicyHolder.FirstName")).sendKeys("TestName");
	  }
	  catch(NoSuchElementException ele)
	  {
			System.out.println("Error");
		  	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try 
			{
				FileUtils.copyFile(src, new File("C:\\Users\\yewal\\eclipse-workspace\\CarInsuranceQuote\\screenshot.jpg"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	  }
  }	
  
  @BeforeClass
  public void beforeClass() 
  {
	//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	//driver = new ChromeDriver();
	driver = loadBrowser(driver);  
	driver.manage().window().maximize();

	String url = ConfigHelper.getConHelper().getUrl();
	
	driver.get(url);
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try 
	{
		FileUtils.copyFile(src, new File("C:\\Users\\yewal\\eclipse-workspace\\CarInsuranceQuote\\screenshot.jpg"));
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
