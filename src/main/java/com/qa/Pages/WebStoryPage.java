package com.qa.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Action.Action;
import com.qa.BaseClass.BaseClass;

public class WebStoryPage extends BaseClass {
	Action acts = new Action();

	public WebStoryPage() {
		PageFactory.initElements(driver, this);
	}

	// Web Stories displayed
	@FindBy(xpath = "(//div[@class='jsx-3628065952 cardin'])[2]")
	WebElement Web_Stories_displayed;

	// Find all WebStorys on WebStory page
	@FindAll(value = { @FindBy(xpath = "(//div[@class='jsx-3628065952 cardin'])") })
	List<WebElement> all_WebStorys;

	// next WebStory
	@FindBy(xpath = "(//div[@class='jsx-3628065952 cardin'])[3]")
	WebElement Next_WebStory;

	// HomePage Button
	@FindBy(xpath = "//span[text()='Home']")
	WebElement HomePage_Button;

	// click on webstory
	public void web_Stories_displayeds() throws InterruptedException {
		acts.switchToFrameByIndex(driver, 0);
		acts.jsClick(driver, Web_Stories_displayed);
	}

	// Find all WebStorys on WebStory page and get text
	public void Find_all_WebStorys_on_WebStory_page_And_GetText() throws InterruptedException {
		acts.switchToFrameByIndex(driver, 0);
		for (int i = 0; i < all_WebStorys.size(); i++) {
			System.out.println(all_WebStorys.get(i).getText());
		}
	}
	
	//click on next web Story and return to home page
	public HomePage click_on_next_WebStory_and_return_To_HomePage() {
		acts.switchToFrameByIndex(driver, 0);
		acts.jsClick(driver, Next_WebStory);
		acts.switchToDefaultFrame(driver);
		acts.jsClick(driver, HomePage_Button);
		return new HomePage();
	}
}
