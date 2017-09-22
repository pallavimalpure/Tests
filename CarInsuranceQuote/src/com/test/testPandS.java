package com.test;

import org.testng.annotations.Test;

import com.config.ConfigHelper;
import com.keywords.KeyWords;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;

public class testPandS extends KeyWords
{
	WebDriver driver;
	
  @Test
  public void getProductAndServices() 
  {
	  driver.findElement(By.xpath("//a[contains(text() , 'Products & Services')]"));
	  driver.findElement(By.xpath("//a[text() = 'isentia.mediaportal: News & Analytics']")).isDisplayed();
	  driver.findElement(By.xpath("//a[text() = 'isentia.mediaportal: Connect ']")).isDisplayed();
	  driver.findElement(By.xpath("//a[text() = 'isentia.mediaportal: Social']")).isDisplayed();
	  
	  List<WebElement> listmodules = driver.findElements(By.xpath("//a[contains(text(),'isentia.mediaportal:')]"));
	  
	  System.out.println("Number of Modules in Media Portal:" + listmodules.size());
	  
	  for (WebElement e : listmodules)
	  {
		  System.out.println("Name of the Modules:" + e.getText());
	  }

  }
  
  @BeforeClass
  public void beforeClass() 
  {
	//System.setProperty("webdriver.internetexplorer.driver", "./Drivers/chromedriver.exe");
	//driver = new ChromeDriver();  
	String operatingSystem = ConfigHelper.getConHelper().getOperatingSystem();
	
	DesiredCapabilities capabilities= new DesiredCapabilities();
	capabilities.setCapability("platform", operatingSystem);
	capabilities.setCapability("browserName", "IE");
	capabilities.setCapability("version", 11);
	
	//driver = loadBrowser(driver);
	
	try
	{
		driver = new RemoteWebDriver(capabilities);
	}
	catch(UnreachableBrowserException con)
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
	String Url = ConfigHelper.getConHelper().getIsentiaUrl();
	driver.get(Url);
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
