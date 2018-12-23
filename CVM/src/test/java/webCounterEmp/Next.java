package webCounterEmp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sedco.CVM.General;

public class Next {
	static int sum;
	public static int WaitingCustomers () {
	int wait = 0;
	sum =0;
	WebElement table = General.driver.findElement(By.id("ServicesTable"));
	List <WebElement> TR = table.findElements(By.tagName("tr"));
	for (int i=1 ;i<TR.size();i++) {
		List <WebElement> TD = TR.get(i).findElements(By.tagName("td"));
		wait = Integer.parseInt(TD.get(1).getText());
		sum = sum+wait;
	}
	return sum;
	}
	
	public static void main(String[] args) throws MalformedURLException {

		General.openBrowser("chrome");
		General.navigate("http://10.0.0.231");
		General.driver.findElement(By.id("txtUsername")).sendKeys("root");
		General.driver.findElement(By.id("txtPassword")).sendKeys("sedco@123");
		General.driver.findElement(By.id("btnLogin")).click();
		WaitingCustomers ();
		System.out.println(sum);
		try {
			while(sum > 0) {
				General.driver.findElement(By.id("btnNext")).click();
				Random rand = new Random();
				int r = rand.nextInt(60) + 70;
				System.out.println(r);
				General.waitFor(r);
				WaitingCustomers ();
				System.out.println(sum);
			}
		}
		catch (Exception e) {
			General.closeBrowser();
		}
		
		finally {
			General.driver.findElement(By.id("btnFinishMain")).click();
			General.driver.findElement(By.id("btnLogout")).click();
			General.closeBrowser();
		}
	}
}
