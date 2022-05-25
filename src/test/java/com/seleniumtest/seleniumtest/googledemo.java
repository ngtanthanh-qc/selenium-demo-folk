package com.seleniumtest.seleniumtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

	public class googledemo {
		String os = System.getProperty("os.name");

		private WebDriver driver;

		@Test(priority=0) 
		public void testJbkTitle() {
		    driver.get("http://www.google.com"); 
		    String title = driver.getTitle(); 
		    System.out.println(title);
		    Assert.assertEquals(title,"Google");
		   
		}

			@BeforeTest
			public void beforeTest() {
				String os = System.getProperty("os.name");
				if(os.contains("Windows")){
					System.setProperty("webdriver.chrome.driver","browserDrivers/chromedriver.exe");
				} else {
					System.setProperty("webdriver.chrome.driver","//usr//bin//chromedriver");}
				driver = new ChromeDriver();
			}

			@AfterTest
			public void afterTest() {
				driver.quit();
			}
		}

