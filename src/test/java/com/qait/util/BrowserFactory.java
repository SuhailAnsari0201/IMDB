package com.qait.util;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	 static WebDriver driver;
	 
	    public static WebDriver startBrowser(String browserName) {
	        if (browserName.equalsIgnoreCase("chrome")) {
	        	System.setProperty("webdriver.chrome.driver",
	        			System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
	            driver = new ChromeDriver();
	           // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        	//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else if (browserName.equalsIgnoreCase("IE")) {
	            driver = new InternetExplorerDriver();
	        }
	     
	        return driver;
	 
	    }

}
