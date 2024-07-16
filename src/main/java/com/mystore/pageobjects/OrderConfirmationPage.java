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
 * Created by Sharu on 12th Jul2024
 */
public class OrderConfirmationPage extends BaseClass {
	
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Shop is complete")
	WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
	}
	
}
