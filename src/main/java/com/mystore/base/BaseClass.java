package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver>	driver = new ThreadLocal<>();
	
	@BeforeSuite(groups= {"smoke" , "Sanity" , "Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	
	@BeforeTest(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() {
		 try {
	            prop = new Properties();
	            System.out.println("Super Constructor Invoked");
	            FileInputStream ip = new FileInputStream(
	                    System.getProperty("user.dir") + "\\Configuration\\Config.properties");
	            prop.load(ip);
	            System.out.println("Config file loaded successfully.");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Config file not found: " + e.getMessage());
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load config file: " + e.getMessage());
	        }
	}
	
	

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public static void launchApp(String browserName) {
		
		 try {
	            WebDriverManager.chromedriver().setup();
	            //browserName = prop.getProperty("browser");
	            if (browserName.equalsIgnoreCase("Chrome")) {
	    			WebDriverManager.chromedriver().setup();
	    			// Set Browser to ThreadLocalMap
	    			driver.set(new ChromeDriver());
	    		} else if (browserName.equalsIgnoreCase("FireFox")) {
	    			WebDriverManager.firefoxdriver().setup();
	    			driver.set(new FirefoxDriver());
	    		} else if (browserName.equalsIgnoreCase("IE")) {
	    			WebDriverManager.iedriver().setup();
	    			driver.set(new InternetExplorerDriver());
	    		}

	         // Maximize the browser window
	          //Maximize the screen
	    		getDriver().manage().window().maximize();
	    		//Delete all the cookies
	    		getDriver().manage().deleteAllCookies();
	    		//Implicit TimeOuts
	    		getDriver().manage().timeouts().implicitlyWait
	    		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
	    		//PageLoad TimeOuts
	    		getDriver().manage().timeouts().pageLoadTimeout
	    		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
	    		
	    		//Launching the URL
	    		getDriver().get(prop.getProperty("url"));
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to launch application: " + e.getMessage());
	        }
	    }
		
		@AfterSuite(groups= {"smoke" , "Sanity" , "Regression"})
		public void afterSuite() {
			ExtentManager.endReport();
		}
}
