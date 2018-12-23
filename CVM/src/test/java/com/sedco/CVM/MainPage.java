package com.sedco.CVM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class MainPage {
	WebDriver driver = General.driver;
	
	public static void SelectBranch() {
		Select Branches = new Select (General.driver.findElement(By.id("branches")));
		Branches.selectByIndex(0);
	}
	
	public static void ClickConnect () {
		General.driver.findElement(By.id("btnconnect")).click();
	}
	
	public static void SelectSegment() {
		Select Segment = new Select (General.driver.findElement(By.id("segments")));
		Segment.selectByIndex(0);
	}
	
	public static void SelectService() {
		Select Service = new Select (General.driver.findElement(By.id("services")));
		Service.selectByIndex(0);
	}
	
	public static void IssueSingleTicket() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(9)")).click();
	}
	
	public static void Issue1000Ticket() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(10)")).click();
	}
	
	public static void SelectCounter() {
		Select Counter = new Select (General.driver.findElement(By.id("counters")));
		Counter.selectByIndex(0);
	}
	
	public static void EnterPassword(String Password) {
		General.driver.findElement(By.id("password")).sendKeys(Password);
	}
	
	public static void LoginWithRoot() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(24)")).click();
	}
	
	public static void GetAllCountersState() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(25)")).click();
	}
	
	public static void GetCurrentState() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(26)")).click();
	}
	
	public static void Open() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(27)")).click();
	}
	
	public static void Next() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(28)")).click();
	}
	
	public static void Next1000() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(29)")).click();
	}
	
	public static void Break() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(30)")).click();
	}
	
	public static void Hold() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(31)")).click();
	}
	
	public static void AddService() {
		Select AddService = new Select (General.driver.findElement(By.id("addservices")));
		AddService.selectByIndex(0);
	}
	
	public static void RefreshStatistics() {
		General.driver.findElement(By.cssSelector("body > button:nth-child(61)")).click();
	}
}
