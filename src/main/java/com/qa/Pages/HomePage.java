package com.qa.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Action.Action;
import com.qa.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	Action acts = new Action();

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Menu button
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeStart'])[1]")
	WebElement menu_button;

	// Change language button
	@FindBy(xpath = "//p[text()='Change Language']")
	WebElement Change_language_button;

	// Buzz button
	@FindBy(xpath = "//span[text()='Buzz']")
	WebElement buzz_button;

	// change themem
	@FindBy(xpath = "//p[text()='Theme']")
	WebElement change_Theme;

	// WebStory
	@FindBy(xpath = "//span[text()='WebStory']")
	WebElement WebStory_button;

	// Change Language
	public void change_language() {
		acts.jsClick(driver, menu_button);
		acts.jsClick(driver, Change_language_button);
	}

	// Find Thumbnail on homepage and find brolen links/images 
	public void find_Thumbnail() throws MalformedURLException, IOException {
		List<WebElement> linklist = driver.findElements(By.tagName("img"));
		linklist.addAll(driver.findElements(By.xpath("//img[contains (@src, 'data')]")));
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < linklist.size(); i++) {

			if (linklist.get(i).getAttribute("src") != null
					&& (!linklist.get(i).getAttribute("src").contains("data"))) {
				activeLinks.add(linklist.get(i));
			}
		}
		System.out.println("Size of Thumbnailes====>" + activeLinks.size());

		for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("src"))
					.openConnection();
			connection.connect();
			int response = connection.getResponseCode();

			if (response >= 400) {
				System.out.println(activeLinks.get(j).getAttribute("src") + "===>Link is Broken");
			}
			connection.disconnect();
		}
	}

	// Click on Buzz and find broken links on third page
	public void find_Broken_Links_On_3rd_Page() throws IOException {
		acts.click(driver, buzz_button);
		List<WebElement> linklist1 = driver.findElements(By.tagName("a"));
		linklist1.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activeLinksonthirdpage = new ArrayList<WebElement>();

		for (int k = 0; k < linklist1.size(); k++) {
			if (linklist1.get(k).getAttribute("href") != null
					&& (!linklist1.get(k).getAttribute("href").contains("data"))) {
				activeLinksonthirdpage.add(linklist1.get(k));
			}
		}
		System.out.println("Size of links====>" + activeLinksonthirdpage.size());

		for (int l = 0; l < activeLinksonthirdpage.size(); l++) {
			HttpURLConnection connection1 = (HttpURLConnection) new URL(
					activeLinksonthirdpage.get(l).getAttribute("href")).openConnection();
			connection1.connect();
			int response1 = connection1.getResponseCode();
			if (response1 >= 400) {
				System.out.println(activeLinksonthirdpage.get(l).getAttribute("href") + "===>Link is Broken");
			}
			connection1.disconnect();
		}
	}

	// Change Theme
	public void change_Theme() {
		acts.jsClick(driver, menu_button);
		acts.jsClick(driver, change_Theme);
	}

	// click on WebStory
	public WebStoryPage click_On_WebStory_button() throws InterruptedException {
		acts.click(driver, WebStory_button);
		return new WebStoryPage();
	}
}
