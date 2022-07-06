package com.qa.BaseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;

	// Launch Browser
	@BeforeMethod
	public void setUp() throws IOException {

		System.setProperty("webdriver.chrome.driver", "C://Users//User//eclipse-workspace//Qa.AutomationAssignment//Chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://thesportstak.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	// tear down Browser
	@AfterMethod
	public void close() throws InterruptedException {
		
		driver.quit();
		
	}

}
