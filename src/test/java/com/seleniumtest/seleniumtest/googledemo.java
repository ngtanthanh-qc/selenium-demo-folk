package com.seleniumtest.seleniumtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

	public class googledemo {
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
				System.setProperty("webdriver.chrome.driver","browserDrivers/chromedriver.exe");
			 driver = new ChromeDriver();
			}

			@AfterTest
			public void afterTest() {
				driver.quit();
			}
		}

