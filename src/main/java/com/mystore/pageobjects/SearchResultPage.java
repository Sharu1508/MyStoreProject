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
public class SearchResultPage extends BaseClass {

	//@FindBy(xpath="//*[@id=\"center_column\"]//img")
	@FindBy(xpath="//img[@class='replace-2x img-responsive']")
	WebElement productResult;
	
	
	public SearchResultPage(){
		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean isProductAvailable() throws Throwable {
		
		return Action.isDisplayed(getDriver(), productResult);
		
	}
	
	public AddToCartPage clickOnProduct() throws Throwable{
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
