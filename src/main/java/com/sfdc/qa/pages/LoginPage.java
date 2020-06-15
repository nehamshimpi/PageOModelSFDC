package com.sfdc.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sfdc.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(id="username")
		WebElement username;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id="Login")
		WebElement loginBtn;
		
		@FindBy(id="signup_link")
		WebElement tryforFree;
		
		@FindBy(xpath="//img[@id='logo']")
		WebElement sfdcLogo;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateSfdcImage(){
			return sfdcLogo.isDisplayed();
		}
		
		public void validLoginCredentials(String un, String pwd){
			WebDriverWait wait = new WebDriverWait(driver, 30);
			username.clear();
			username.sendKeys(un);
			password.clear();
			password.sendKeys(pwd);
			loginBtn.click();
				
			    
		}
		
		public void login_invalidCredentials(String un, String pwd){
			WebDriverWait wait = new WebDriverWait(driver, 30);
			username.clear();
			username.sendKeys(un);
			password.clear();
			password.sendKeys(pwd);
			loginBtn.click();			
			    
		}

		
		
		
}
