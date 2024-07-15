package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeTest
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
	
	public static void launchApp() {
		
			
		 try {
	            WebDriverManager.chromedriver().setup();
	            String browserName = prop.getProperty("browser");
	            if (browserName.equalsIgnoreCase("chrome")) {
	                driver = new ChromeDriver();
	            } else if (browserName.equalsIgnoreCase("firefox")) {
	                driver = new FirefoxDriver();
	            } else if (browserName.equalsIgnoreCase("ie")) {
	                driver = new InternetExplorerDriver();
	            } else {
	                throw new RuntimeException("Unsupported browser: " + browserName);
	            }

	            System.out.println("Browser launched: " + browserName);

	            Action.implicitWait(driver, 10);
	            Action.pageLoadTimeOut(driver, 10);
	            driver.get(prop.getProperty("url"));
	            System.out.println("Navigated to URL: " + prop.getProperty("url"));
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to launch application: " + e.getMessage());
	        }
	    }

	

}
