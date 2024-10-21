package utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class WaitUtil extends BaseClass{
	
	static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	
	public static void waitForElementVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
}
