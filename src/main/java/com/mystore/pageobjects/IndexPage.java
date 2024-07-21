package com.mystore.pageobjects; 

//We are writing our page objects using page factory method

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	//@FindBy(xpath="//*[@id='header_logo']/a/img/")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable
	{
		Action.fluentWait(getDriver(), signInBtn, 10);
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean ValidateLogo() {
		
		return Action.isDisplayed(getDriver(), myStoreLogo);
		
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle1=getDriver().getTitle();
		return myStoreTitle1;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
	
}

