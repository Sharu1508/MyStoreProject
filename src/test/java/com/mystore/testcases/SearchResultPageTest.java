/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * Created by Sharu on 17th Jul'24
 */
public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
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

    @Test(groups = "smoke")
    public void productAvailabilityTest() throws Throwable {
    	indexPage= new IndexPage();
    	searchResultPage = indexPage.searchProduct("dress");
    	boolean result =  searchResultPage.isProductAvailable();
    	Assert.assertTrue(result);
 	
    }
}
