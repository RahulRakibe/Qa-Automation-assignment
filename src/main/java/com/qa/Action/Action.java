package com.qa.Action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.BaseClass.BaseClass;

public class Action extends BaseClass {

	// click by java script
	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// click on element by move to element method
	public void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	// to scroll upto element
	public void scrollUpToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// scrollUpTOcordinate
	public void scrollUpToCordinate(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}

	// send text by send keys
	public void text(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	// select vlaue from dropdown by
	// 1.By index

	public void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	// 2.ByValue
	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// 3.ByVisibleText
	public void selectByVisibleText(WebElement element, String visibletext) {
		Select s = new Select(element);
		s.selectByVisibleText(visibletext);
	}

	// Frame: Switch to frame
	// 1.By index
	@SuppressWarnings("deprecation")
	public void switchToFrameByIndex(WebDriver driver, int index) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(index);
	}

	// 2.By ID Value
	@SuppressWarnings("deprecation")
	public void switchToFrameByIdValue(WebDriver driver, String idValue) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(idValue);
	}

	// 3.By Name
	@SuppressWarnings("deprecation")
	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
		driver.switchTo().frame(element);
	}

	// switch to DefaultFrame
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// switch back letest parent frame
	public void switchToParentFraem(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void moveToElement(WebDriver driver, WebElement target) {
		Actions clicke = new Actions(driver);
		clicke.moveToElement(target).build().perform();
	}

	// Drag and Drop
	public void draganddrop(WebDriver driver, WebElement source, WebElement target) {
		new Actions(driver).dragAndDrop(source, target).build().perform();
	}

	// Rightclick on element
	public void rightclick(WebDriver driver, WebElement element) {
		Actions clicke = new Actions(driver);
		clicke.contextClick(element).build().perform();
	}

	// switch to new window
	public void switchToWindow(WebDriver driver) {
		String parent_window = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> it = allwindows.iterator();

		while (it.hasNext()) {
			String child_window = it.next();
			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
	}

	// Alerts
	// Accept alert
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Dismiss
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// send text to alert
	public void sendTestToAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);

	}

	// Get Text From Alert
	public void getTextFromAlert(WebDriver driver) {
		driver.switchTo().alert().getText();

	}

	// Waits
	// implicitWait
	@SuppressWarnings("deprecation")
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// ExplicitWait
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// To take Screenshot
	public static void screenShot() {
		try {
			Date date = new Date();

			String filename = date.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot Take = ((TakesScreenshot) driver);

			File src = Take.getScreenshotAs(OutputType.FILE);

			File Dest = new File(
					System.getProperty("user.dir") + ".\\FailedScreenshotes\\" + "screenshot-" + filename + ".png");

			FileHandler.copy(src, Dest);
		} catch (IOException e) {
			System.out.println("Show Exception");
		}
	}

}
