package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	@FindBy(name = "username")
	WebElement uName;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage login(String username, String password) {
		
		//WaitUtil.waitForElementVisible(uName);
		uName.sendKeys(username);
		pwd.sendKeys(password);
		submitBtn.click();
		
		return new HomePage(driver);
	}
}
