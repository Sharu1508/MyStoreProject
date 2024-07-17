/**
 * 
 */
package com.mystore.testcases;

import org.apache.poi.ss.formula.functions.Index;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * Created by Sharu on 17th Jul'24
 */
public class HomePageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage	loginPage;
	HomePage homePage;
	
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
    
    @Test
    public void wishListTest() throws Throwable{
    	indexPage= new IndexPage();
    	loginPage = indexPage.clickOnSignIn();
    	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	boolean result=homePage.validateMyWishList();
    	Assert.assertTrue(result);
    }
    @Test
    public void orderHistoryandDetailsTest() throws Throwable{
    	indexPage= new IndexPage();
    	loginPage = indexPage.clickOnSignIn();
    	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	boolean result=homePage.validateOrderHistory();
    	Assert.assertTrue(result);
    }
	
}
