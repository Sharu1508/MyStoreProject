/**
 * 
 */
package com.mystore.testcases;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * Created by Sharu on 17th Jul'24
 */
public class AccountCreationPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
	
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
    
    @Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(email);
		boolean result=accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("createAccountTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		accountCreationPage.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage=accountCreationPage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
		Log.endTestCase("createAccountTest");
	}

}