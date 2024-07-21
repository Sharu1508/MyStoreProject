	/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * Created by Sharu on 17th Jul'24
 */
public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void setup(@Optional("Chrome") String browser) {
		try {
			System.out.println("Launching application...");
			launchApp(browser);
			System.out.println("Application launched successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Setup failed: " + e.getMessage());
		}
	}
    @AfterMethod(groups = {"Smoke" , "Sanity" , "Regression"})
    public void tearDown() {
        if (driver != null) {
        	getDriver().quit();
            System.out.println("Browser closed.");
        }
    }
	
    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Sanity"})
    public void loginTest(String uname, String pswd) throws Throwable {
    	Log.startTestCase("loginTest");
    	indexPage =  new IndexPage();
    	Log.info("user is going to click on SignIn");
    	loginPage=indexPage.clickOnSignIn();
    	Log.info("enter Username and Password");
    	//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	homePage=loginPage.login(uname, pswd);
    	String actualURL = homePage.getCurrURL();
    	String expectedURL ="http://www.automationpractice.pl/index.php?controller=my-account";
    	Log.info("Verifying if user is able to login");
    	Assert.assertEquals(actualURL, expectedURL);
    	Log.info("Login is sucess");
    	Log.endTestCase("loginTest");
    }
    
    
}
