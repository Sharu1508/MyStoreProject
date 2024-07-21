/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * Created by Sharu on 15th Jul'24
 */
public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke" , "Sanity" , "Regression"})
	public void setup(String browser) {
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
	
	@Test(groups="Smoke")
	public void verifyLogo() throws Throwable{
		indexPage = new IndexPage();
		boolean result=indexPage.ValidateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() throws Throwable{
		String actTitle=indexPage.getMyStoreTitle();
		System.out.println("The actual title is: "+actTitle);
		Assert.assertEquals(actTitle, "My Shop");
	
	}
	
}
