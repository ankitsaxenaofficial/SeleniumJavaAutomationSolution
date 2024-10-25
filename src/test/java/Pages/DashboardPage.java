package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[text()='Login mit App bestätigen']")
	WebElement loginSuccess;
	
	public boolean checkForLoginSuccessfull() throws InterruptedException {
		
		
		return loginSuccess.isDisplayed();
		
	}
}

