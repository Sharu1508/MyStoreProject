/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * Created by Sharu on 17th Jul'24
 */
public class OrderPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@BeforeMethod
	public void setup() {
		try {
			System.out.println("Launching application...");
			launchApp();
			System.out.println("Application launched successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Setup failed: " + e.getMessage());
		}
	}
	
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
    public void verifyTotalPrice() throws Throwable {
    	indexPage= new IndexPage();
    	
    	searchResultPage = indexPage.searchProduct("Blouse");
    	addToCartPage= searchResultPage.clickOnProduct();
    	addToCartPage.eneterQuantity("1");
    	addToCartPage.selectSize("S");
    	addToCartPage.clickOnAddToCart();
    	addToCartPage.clickOnCheckout();
    	boolean result = addToCartPage.validateAddToCart();
    	Assert.assertTrue(result);
 	
    }


}
