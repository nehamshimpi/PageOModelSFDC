package com.sfdc.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sfdc.qa.base.TestBase;
import com.sfdc.qa.pages.HomePage;
import com.sfdc.qa.pages.LoginPage;
import com.sfdc.qa.utils.CommanUtils;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		launch_Browser(); 
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void validateLoginPageTitle()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login | Salesforce");
		
	}
	
	@Test(priority=2 )
	public void validateLogoOfPageTitle()
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
	public void tc1NavigateToSFDC(String sUsername,String sPassword )
	{		
		loginPage.validLoginCredentials(sUsername,sPassword);
		System.out.println("logged in successfully!");
		
	}
	
	@DataProvider(name = "InvalidUsernameAndPassword")
	public Object[][] getInvalidLoginTestData() throws Exception{
		Object data[][] = CommanUtils.readDataFromExcelSheet("InvalidCredentials");
		return data;
	}
	
	@Test(priority=4, dataProvider="InvalidUsernameAndPassword")
	public void logintest_invalidCredentials(String sUsername, String sPassword) {
		loginPage.login_invalidCredentials(sUsername,sPassword);
		WebElement loginError=driver.findElement(By.xpath("//div[@id='error']"));
		String error = loginError.getText();
		System.out.println(error);	
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
