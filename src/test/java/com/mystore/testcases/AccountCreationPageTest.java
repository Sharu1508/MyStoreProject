/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * Created by Sharu on 17th Jul'24
 */
public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
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
    public void verifyCreateAccountpageTest() throws Throwable {
    	
    	indexPage= new IndexPage();
    	loginPage=indexPage.clickOnSignIn();
    	accountCreationPage=loginPage.createNewAccount("ahhhshshhh@gmail.com");
    	boolean result = accountCreationPage.validateAccountCreatePage();
    	Assert.assertTrue(result);
    	
    }
}
