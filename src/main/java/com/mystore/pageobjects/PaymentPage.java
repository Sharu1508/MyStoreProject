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
public class PaymentPage extends BaseClass{
		
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement bankWireMethod;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement payByCheckMethod;
	
	
	public PaymentPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
			Action.click(getDriver(), bankWireMethod);
			return new OrderSummaryPage();
	}
	
	
}
