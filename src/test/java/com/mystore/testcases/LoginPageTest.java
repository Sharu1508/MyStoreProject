/**
 * 
 */
package com.mystore.testcases;

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
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
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
    public void loginTest() throws Throwable {
    	indexPage =  new IndexPage();
    	loginPage=indexPage.clickOnSignIn();
    	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	String actualURL = homePage.getCurrURL();
    	String expectedURL ="http://www.automationpractice.pl/index.php?controller=my-account";
    	Assert.assertEquals(actualURL, expectedURL);
    	
    }
    
    
}
