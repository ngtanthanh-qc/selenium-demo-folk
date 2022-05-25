package com.seleniumtest.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
			System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver");
			driver = new ChromeDriver();
		}

		@AfterTest
		public void afterTest() {
			driver.quit();
		}
	}
