package com.sedco.CVM;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class General {
	public static WebDriver driver;
	
	public static void openBrowser(String browserName) throws MalformedURLException {
		
		switch (browserName) {
		
		case "chrome":
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		
		case "Firefox":
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		}
			//The below block is to start the test on remote computer using Selenium Grid.
			//You have to start a Hub machine and a node machine in order to work with Grid then update the below block as needed
			
/*			String baseURL,nodeURL;
			baseURL ="http://10.0.10.71/SEDCOWebServer/";
			nodeURL="http://10.0.0.171:5566/wd/hub";
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), capability);
			driver.get(baseURL);
			driver.findElement(By.id("txtUserName")).sendKeys("root");
			driver.findElement(By.id("txtPassword")).sendKeys("root", Keys.ENTER);*/
		}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	public static void navigate(String URL) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	public static void waitFor(int waitTime) throws Exception {
		int wait = waitTime*1000;
		Thread.sleep(wait);
	}
	
	public static void ScrollPageDown (int scrollAmount) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+scrollAmount+")", "");
	}
	

}
