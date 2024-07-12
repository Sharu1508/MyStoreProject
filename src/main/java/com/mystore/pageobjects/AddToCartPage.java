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
public class AddToCartPage extends BaseClass {
	
	Action action = new Action();
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text()='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;

	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void eneterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);
	}
	public void selectSize(String size1) throws Throwable {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable{
		action.click(driver, addToCartBtn);
	}

	public boolean validateAddToCart() throws Throwable{
		return action.isDisplayed(driver, addToCartMessage);
	}
	
	public OrderPage clickOnCheckout() throws Throwable {
		action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
}
