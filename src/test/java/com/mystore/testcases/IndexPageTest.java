/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * Created by Sharu on 13th Jul'24
 */
public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
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
	public void verifyLogo() throws Throwable{
		indexPage = new IndexPage();
		boolean result=indexPage.ValidateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() throws Throwable{
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Shop");
	
	}
	
	
}
