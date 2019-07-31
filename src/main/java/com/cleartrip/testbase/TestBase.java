package com.cleartrip.testbase;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class TestBase {
	public static  WebDriver driver; 
	public static Properties prop;
	
	public TestBase(){
		try {
		FileInputStream fis=new FileInputStream("src\\main\\java\\com\\cleartrip\\config\\application.properties");
		prop=new Properties();
		prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest()
	public void initialize() {
		setDriverPath();
	}
	
	private void setDriverPath() {
	        if (PlatformUtil.isMac()) {
	            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver");
	        }
	        if (PlatformUtil.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	        }
	        if (PlatformUtil.isLinux()) {
	            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_linux");
	        }
	        
	        driver=new ChromeDriver();
	    }
	
	public void openSite() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
