package Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import Base.RetryAnalyzer;
import Pages.BackToLoginPage;
import Pages.DashboardPage;
import Pages.HomePage;
import Pages.LoginPage;
import utilities.ReadExcel;
import utilities.WrapperUtilities;

public class LoginTest extends BaseClass {	

	LoginPage loginPage;
	HomePage homePage;
	BackToLoginPage backToLoginPage;
	SoftAssert as;
	DashboardPage dashboardPage;

	private static final Logger logger = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void acceptAndContinue() {
		try {
			BaseClass.launchURL();
			homePage = new HomePage(getDriver());
			homePage.switchFrames();
			homePage.clickAcceptAndContinueButton();
		} catch (Exception e) {
			System.out.println("Error in @BeforeMethod: " + e.getMessage());
		}
	}

	//Login Test for Valid Credentials
	@Test(enabled = true) 
	public void validLogin() throws InterruptedException {

		loginPage = new LoginPage(getDriver());
		dashboardPage = new DashboardPage(getDriver());
		try {
			loginPage.directLogin(ReadExcel.GetExcelCellData(1, 0), ReadExcel.GetExcelCellData(1, 1));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		boolean isLoginSuccessful = dashboardPage.checkForLoginSuccessfull();
		as = new SoftAssert();
		as.assertEquals(true, isLoginSuccessful);
		as.assertAll();
	}	
	
	// Login Test for Blank Username and Password
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void userLoginBlank() throws InterruptedException {

		logger.info("----userLoginBlank Test Starts----");
		loginPage = new LoginPage(getDriver());
		loginPage.directLogin("", "");
		backToLoginPage = new BackToLoginPage(getDriver());
		as = new SoftAssert();
		as.assertEquals(true,backToLoginPage.loginFailedMessage());	
		as.assertAll();
		logger.info("----userLoginRandom Test Ends----");
	}
	
	// Login Test for Random Username and Password
		@Test(retryAnalyzer = RetryAnalyzer.class)
		public void userLoginRandom() throws InterruptedException {

			logger.info("----invalidLogin Test Starts----");
			loginPage = new LoginPage(getDriver());
			loginPage.directLogin(WrapperUtilities.generateRandomUsername()+"@gmx.com", WrapperUtilities.generateRandomPassword());
			backToLoginPage = new BackToLoginPage(getDriver());
			as = new SoftAssert();
			as.assertEquals(true,backToLoginPage.loginFailURL());	
			as.assertAll();
			logger.info("----invalidLogin Test Ends----");
		}		
	
	// Login Test for zurückZumLogin Button
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void  zurückZumLogin() throws InterruptedException {
		
		logger.info("----zurückZumLogin Test Starts----");
		loginPage = new LoginPage(getDriver());
		loginPage.directLogin("ankitsaxena@gmx.com", "Hello@123");
		backToLoginPage = new BackToLoginPage(getDriver());
		as = new SoftAssert();
		as.assertEquals(true,backToLoginPage.loginFailURL());
		as.assertEquals(true,backToLoginPage.clickOnBackToLogin().verifyIfLoginBtnExist());		
		as.assertAll();		
		logger.info("----zurückZumLogin Test Ends----");
	}
}
