package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestAddBetForHorseRacing 
{
	WebDriver driver;
	
  @Test
  public void testAddBet() throws InterruptedException
  {
	  driver.findElement(By.linkText("Bet Now")).click();
	  Thread.sleep(5000);
	  //driver.findElement(By.xpath(".//a[@id = 'horse_racing']")).click();
	  //driver.findElement(By.xpath(".//a[contains(normalize-space(.), 'Horse Racing')]")).click();
	  //driver.findElement(By.linkText("Horse Racing")).click();
	  driver.findElement(By.id("selectedNavA")).click();
  }

  @BeforeClass
  public void beforeClass()
  {
	  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.williamhill.com/#!/");
	  
  }

  @AfterClass
  public void afterClass() 
  {
	  //driver.close();
  }

}
