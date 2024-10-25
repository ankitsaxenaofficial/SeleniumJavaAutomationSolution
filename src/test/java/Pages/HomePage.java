package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WrapperUtilities;

public class HomePage extends BasePage {


	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "save-all-pur")
	WebElement acceptAndContinue;

	@FindBy(css = "iframe[name='landingpage']")
	WebElement outerFrame;

	@FindBy(css = "iframe[title='CMP']")
	WebElement innerFrame;

	@FindBy(css = "button[class='goToHPButton']")
	WebElement gotToHomePage;

	public void clickAcceptAndContinueButton() {

		try {
			WrapperUtilities.switchToNestedFrames(driver, outerFrame, innerFrame);
			WrapperUtilities.waitForElementVisible(acceptAndContinue);
			acceptAndContinue.click();
		}catch(Exception e) {
			WrapperUtilities.waitForElementVisible(gotToHomePage);
			gotToHomePage.click();
			WrapperUtilities.waitForElementVisible(acceptAndContinue);
			acceptAndContinue.click();
		}
	}

	public void switchFrames() {

	}
}

