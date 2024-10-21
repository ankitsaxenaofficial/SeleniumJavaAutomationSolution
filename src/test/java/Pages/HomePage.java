package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//img[@alt='client brand banner']")
	WebElement profilePic;
	
	//public boolean isProfilePicPresent() {
		
		//WaitUtil.waitForElementVisible(profilePic);
		//return profilePic.isDisplayed();
	}

