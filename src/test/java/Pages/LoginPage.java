package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WrapperUtilities;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'Mail-Account anlegen')]")
	WebElement loginButton;
	
	@FindBy(css = "a[aria-label='Login']")
	WebElement mainLoginBtn;
	
	@FindBy(css = "input#mailInput")
	WebElement email;
	
	@FindBy(id = "pwInput")
	WebElement pwd;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement directLoginBtn;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage clickLoginButton() {
		WrapperUtilities.waitForElementVisible(loginButton);
		loginButton.click();
		WrapperUtilities.waitForElementVisible(mainLoginBtn);
		mainLoginBtn.click();
		return new LoginPage(driver);
	}
	
	public DashboardPage directLogin(String username, String password) {
		
		WrapperUtilities.waitForElementVisible(directLoginBtn);
		email.sendKeys(username);
		pwd.sendKeys(password);
		directLoginBtn.click();
		
		return new DashboardPage(driver);
	}
	
	public boolean verifyIfLoginBtnExist() throws InterruptedException {
		
		
		 return WrapperUtilities.waitForElementVisible(directLoginBtn).isDisplayed();
	}
}
