package com.mystore.pageobjects; 

//We are writing our page objects using page factory method

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn()
	{
		
		action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public void ValidateLogo() {
		
		action.isDisplayed(driver, myStoreLogo);
		
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle1=driver.getTitle();
		return myStoreTitle1;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.click(driver, searchButton);
		return new SearchResultPage();
	}
	
}

