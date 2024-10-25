package utilities;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BaseClass;

public class WrapperUtilities extends BaseClass{

	public static void switchToNestedFrames(WebDriver driver, WebElement outerFrame, WebElement innerFrame) {

		waitForElementVisible(outerFrame);
		// Switch to Outer Frame
		driver.switchTo().frame(outerFrame);

		waitForElementVisible(innerFrame);		
		// Switch to Inner Frame		
		driver.switchTo().frame(innerFrame);
	}
	
	public static String generateRandomUsername() {
		
		return UUID.randomUUID().toString().substring(0,8);
	}
	
	public static String generateRandomPassword() {
		return UUID.randomUUID().toString().substring(0,12);
	}

	static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
	
	public static WebElement waitForElementVisible(WebElement ele) {
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForPageLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Wait until the ready state is complete
        while (!js.executeScript("return document.readyState").equals("complete")) {
            try {
                Thread.sleep(10); // Sleep for a short period to avoid busy waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void stopLoading(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
		
	}
	
}
