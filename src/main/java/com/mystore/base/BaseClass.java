package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"smoke" , "Sanity" , "Regression"})
	public void beforeSuite() {
		DOMConfigurator.configure("log4j.xml");
	}
	
	@BeforeMethod
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
	

	public static void launchApp(String browserName) {
		
		 try {
	            WebDriverManager.chromedriver().setup();
	            //browserName = prop.getProperty("browser");
	            if (browserName.equalsIgnoreCase("chrome")) {
	                driver = new ChromeDriver();
	            } else if (browserName.equalsIgnoreCase("firefox")) {
	                driver = new FirefoxDriver();
	            } else if (browserName.equalsIgnoreCase("ie")) {
	                driver = new InternetExplorerDriver();
	            } else {
	                throw new RuntimeException("Unsupported browser: " + browserName);
	            }

	         // Maximize the browser window
	            driver.manage().window().maximize();
	            System.out.println("Browser launched and maximized: " + browserName);
	            System.out.println("Browser launched: " + browserName);
	            driver.get(prop.getProperty("url"));
	            Action.implicitWait(driver, 10);
	            Action.pageLoadTimeOut(driver, 10);
	            System.out.println("Navigated to URL: " + prop.getProperty("url"));
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to launch application: " + e.getMessage());
	        }
	    }
}
