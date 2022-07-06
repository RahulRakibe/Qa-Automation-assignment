package com.qa.Tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.asserts.SoftAssert;
import com.qa.BaseClass.BaseClass;
import com.qa.Pages.HomePage;
import com.qa.Pages.WebStoryPage;

public class Test1 extends BaseClass {
	HomePage homePage;
	WebStoryPage webStoryPage1;
	SoftAssert asserts = new SoftAssert();

//Task 1.Open The Website & Select the language
	@Test(priority = 1)
	public void change_Language() {
		homePage = new HomePage();
		homePage.change_language();
		String Actualtitle = driver.getTitle();
		String expectedTitle = "खेल समाचार, वीडियो, लाइव-एक्शन, ग्राफिक्स आँकड़े, हाइलाइट्स | स्पोर्ट्स तक";
		asserts.assertEquals(Actualtitle, expectedTitle);
		asserts.assertAll();
	}

//Task 2. Click on each thumbnil and verify that links are not broken on homepage
	@Test(priority = 2)
	public void verify_Links_Are_Not_Broken_On_HomePage() throws MalformedURLException, IOException  {
		homePage = new HomePage();
		homePage.find_Thumbnail();	
	}

	// Task 3. Click on Buzz and scrollto the 3rd pagee and
//         click on the links and verifynthe links are not broken   
	@Test(priority = 3)
	public void verify_Links_Are_Not_Broken_On_Third_Page() throws IOException {
		homePage = new HomePage();
		homePage.find_Broken_Links_On_3rd_Page();
	}

//Task 4.Click on the menu and change the theme
	@Test(priority = 4)
	public void change_Theme() {
		homePage = new HomePage();
		homePage.change_Theme();
	}

//Task 5.Click on any Web Stories displayed
	@Test(priority = 5)
	public void click_on_Web_Sotries() throws InterruptedException {
		homePage = new HomePage();
		webStoryPage1 = new WebStoryPage();
		homePage.click_On_WebStory_button();
		webStoryPage1.web_Stories_displayeds();
	}

//Task 6.Capture the text on each Web Stories and each page of webstory
	@Test(priority = 6)
	public void capture_The_Text_From_each_WebStory() throws InterruptedException {
		homePage = new HomePage();
		webStoryPage1 = new WebStoryPage();
		homePage.click_On_WebStory_button();
		webStoryPage1.Find_all_WebStorys_on_WebStory_page_And_GetText();
	}

//Task 7.Click on the next WebStory and return on the homepage
	@Test(priority = 7)
	public void click_on_next_WebStory_and_Return_on_HomePage() throws InterruptedException {
		homePage = new HomePage();
		webStoryPage1 = new WebStoryPage();
		homePage.click_On_WebStory_button();
		webStoryPage1.click_on_next_WebStory_and_return_To_HomePage();
		String actualHomepageTitle = driver.getTitle();
		String expectedHomepagetitle = "Sports News,Videos,Live-Actions,Graphics Stats,Highlights|SportsTak";
		asserts.assertEquals(actualHomepageTitle, expectedHomepagetitle);
		asserts.assertAll();
	}
}
