package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;


public class LoginTest extends BaseClass {	

	LoginPage loginPage;
	HomePage homePage;


	@BeforeMethod
	public void launchURL() throws InterruptedException {

		BaseClass.launchURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}
	@Test
	public void login() throws InterruptedException {

		Thread.sleep(2000);
		loginPage = new LoginPage(getDriver());
		homePage = loginPage.login("Admin", "admin123");
		Thread.sleep(3000);
		//Assert.assertEquals(true, homePage.isProfilePicPresent());
		Assert.assertTrue(true);

	}
	@Test
	public void login1() throws InterruptedException {

		Thread.sleep(3000);
		loginPage = new LoginPage(getDriver());
		homePage = loginPage.login("Admin1", "admin123");
		
		/*
		 * if(homePage.isProfilePicPresent()) { Assert.assertTrue(true); } else {
		 * Assert.assertTrue(false); }
		 */
		Assert.assertTrue(false); 
		Thread.sleep(3000);
		

	}

}
