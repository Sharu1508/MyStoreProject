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
 * Created by Sharu on 9th Jul2024
 */
public class HomePage extends BaseClass {
	
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList() throws Throwable {
		return Action.isDisplayed(driver, myWishList);
		
	}
	public void validateOrderHistory() {
		Action.isDisplayed(driver, orderHistory);
	}
}
