package com.sfdc.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;
import org.apache.log4j.Logger;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.HomePage;
import com.sfdc.qa.pages.LoginPage;
import com.sfdc.qa.utils.CommanUtils;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public static Logger log = Logger.getLogger(LoginPageTest.class.getName());
	
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		log.info("Launching the Browser");
		launch_Browser(); 
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void validateLoginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		log.info(title);
		Assert.assertEquals(title, "Login | Salesforce");
		
	}
	
	@Test(priority=2 )
	public void validateLogoOfPageTitleTest()
	{
		boolean flag = loginPage.validateSfdcImage();
		Assert.assertTrue(flag);
		
	}
	
	@DataProvider(name = "Data_UsernameAndPassword")
	public Object[][] getValidLoginTestData() throws Exception {
		//String sFile = System.getProperty("/Users/neha/eclipse-workspace/PageOModelSFDCProject/POMSFDC.xls");
		Object data[][] = CommanUtils.readDataFromExcelSheet("ValidCredentials");
		return data;
	}
		
	

	@Test(priority=3 , dataProvider="Data_UsernameAndPassword")
	public void validCredentialsSFDCTest(String sUsername,String sPassword )
	{		
		loginPage.validLoginCredentials(sUsername,sPassword);
		log.info("logged in successfully!");
		
	}
	
	@DataProvider(name = "InvalidUsernameAndPassword")
	public Object[][] getInvalidLoginTestData() throws Exception{
		Object data[][] = CommanUtils.readDataFromExcelSheet("InvalidCredentials");
		return data;
	}
	
	@Test(priority=4, dataProvider="InvalidUsernameAndPassword")
	public void invalidCredentialsSFDCTest(String sUsername, String sPassword) {
		loginPage.login_invalidCredentials(sUsername,sPassword);
		WebElement loginError=driver.findElement(By.xpath("//div[@id='error']"));
		String error = loginError.getText();
		log.error(error);
			
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Quit the browser.");
	}
	

}
