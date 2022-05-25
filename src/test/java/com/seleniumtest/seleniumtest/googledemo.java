package com.seleniumtest.seleniumtest;

import org.openqa.selenium.chrome.ChromeOptions;
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
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized"); // open Browser in maximized mode
				options.addArguments("disable-infobars"); // disabling infobars
				options.addArguments("--disable-extensions"); // disabling extensions
				options.addArguments("--disable-gpu"); // applicable to windows os only
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--no-sandbox"); // Bypass OS security model
				options.addArguments("--disable-setuid-sandbox");
				options.addArguments("--disable-dev-shm-using");
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}

			@AfterTest
			public void afterTest() {
				driver.quit();
			}
		}

