package com.seleniumtest.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazondemo {

		private WebDriver driver;

		@Test(priority = 0)
		public void testJbkTitle() {
			driver.get("https://www.amazon.in");
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title,
					"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			// driver.manage().window().setPosition(new Point(100,30));
		}

		@Test(priority = 1)
		public void testJbkTitleInvalid() {
			driver.manage().window().maximize();			
			WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
			SearchBox.sendKeys("Hp Laptop");

		}

		@Test(priority = 2)
		public void testJbkTitlesubmit() {
			WebElement SearchIcon = driver.findElement(By.id("nav-search-submit-button"));
			SearchIcon.click();
		}

		@Test(priority = 3)
		public void testJbkTitlecheck() {
			WebElement Listbox = driver.findElement(By.id("p_72/1318476031"));
			Listbox.click();
		}

		@Test(priority = 3)
		public void testJbkTitlescroll() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Thread.sleep(3000);			
			js.executeScript("window.scrollBy(0,5000)");
			Thread.sleep(3000);
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
//			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}

		@AfterTest
		public void afterTest() {
			driver.quit();
		}

	}
