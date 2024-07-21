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
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessage;
	
	//@FindBy(xpath="//span[contains(text()='Proceed to checkout']")
	@FindBy(css = "a.btn.btn-default.button.button-medium[title='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;

	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void eneterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
	}
	public void selectSize(String size1) throws Throwable {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable{
		Action.click(getDriver(), addToCartBtn);
	}

	public boolean validateAddToCart() throws Throwable{
		Action.fluentWait(getDriver(), addToCartMessage, 10);
		return Action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnCheckout() throws Throwable {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
