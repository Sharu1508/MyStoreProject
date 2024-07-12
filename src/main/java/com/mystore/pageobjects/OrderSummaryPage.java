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
	
	Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public OrderConfirmationPage clickOnconfirmOrderBtn()throws Throwable {
		
		action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
		
	}

}
