/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * Created by Sharu on 8th Jul2024
 */
public class LoginPage extends BaseClass {
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement SignInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	WebElement createNewAccountBtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public HomePage login(String uname, String pswd) throws Throwable{
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, SignInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname, String pswd) throws Throwable{
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(driver, SignInBtn);
		return new AddressPage();
	}
	
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		return new AccountCreationPage();
	}
	
}

