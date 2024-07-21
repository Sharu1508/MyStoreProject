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
public class OrderSummaryPage extends BaseClass{
	
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public OrderConfirmationPage clickOnconfirmOrderBtn()throws Throwable {
		
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
		
	}

}
