package cvmServer;

import org.openqa.selenium.By;

import com.sedco.CVM.General;

public class LoginPage {
	
	public static void EnterUsername(String username) {
		General.driver.findElement(By.id("UserName")).sendKeys(username);
	}
	
	public static void EnterPassword(String password) {
		General.driver.findElement(By.id("CurrentPassword")).sendKeys(password);
	}
	
	public static void ClickLogin() {
		General.driver.findElement(By.id("btnLogin")).click();
	}

}
