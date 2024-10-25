package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {	
	
protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		
	static String url = "https://www.gmx.net/consent-management";
	
	@BeforeMethod
	public static void setDriver() throws MalformedURLException, URISyntaxException {	
			tlDriver.set(new ChromeDriver());	
	}
	
	@AfterMethod
	public static void quitDriver() {		
		getDriver().quit();
		tlDriver.remove();
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}	
	
	public static void launchURL() throws InterruptedException {			
			getDriver().get(url);
			getDriver().manage().window().maximize();
	}
	
	public static String captureScreenshot(String name) {
		
		TakesScreenshot screenshot = (TakesScreenshot) getDriver();
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
}
