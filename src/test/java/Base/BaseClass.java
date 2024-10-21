package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	static String hubURL = "http://localhost:4444/wd/hub";
	static DesiredCapabilities cap;
	
	
protected static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		
	@BeforeMethod
	@Parameters({"browser"})
	public static void setDriver(String browser) throws MalformedURLException, URISyntaxException {
		cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WIN10);
		if(browser.equalsIgnoreCase("chrome")) {
		cap.setPlatform(Platform.LINUX);	
		cap.setBrowserName("chrome");
		}
		else {
			cap.setPlatform(Platform.LINUX);
		cap.setBrowserName("firefox");
		}
		tlDriver.set(new RemoteWebDriver(new URI(hubURL).toURL(), cap));
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}	
	
	public static void launchURL(String url) throws InterruptedException {
		
		getDriver().get(url);
		
	}
	
	@AfterMethod
	public static void quitDriver() {
		
		getDriver().quit();
		tlDriver.remove();
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
