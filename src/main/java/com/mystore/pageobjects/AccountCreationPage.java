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
 *Created by Sharu on 8th Jul2024 
 */
public class AccountCreationPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateAccountCreatePage() throws Throwable {
		action.isDisplayed(driver, formTitle);
	}
}
