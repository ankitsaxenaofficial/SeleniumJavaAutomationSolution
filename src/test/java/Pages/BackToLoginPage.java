package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WrapperUtilities;

public class BackToLoginPage extends BasePage{

	public BackToLoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "div[data-component='notification']")
	WebElement errorMsg;
	
	@FindBy(xpath = "//a[text()=' Zurück zum Login ']")
	WebElement backToLoginBtn;
	
	public boolean loginFailedMessage() throws InterruptedException  {
		WrapperUtilities.stopLoading(driver);
		WrapperUtilities.waitForElementVisible(backToLoginBtn);
		return WrapperUtilities.waitForElementVisible(errorMsg).isDisplayed();
		
	}
	
	public boolean loginFailURL() throws InterruptedException {
		
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("login-failed")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public LoginPage clickOnBackToLogin() throws InterruptedException {
		
		WrapperUtilities.stopLoading(driver);
		WrapperUtilities.waitForElementVisible(backToLoginBtn);
		backToLoginBtn.click();
		return new LoginPage(driver);
	}
	
}
