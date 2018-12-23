package cvmServer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sedco.CVM.General;

public class HomePage {

	public static void QueuingAndRouting() {
		General.driver.findElement(By.cssSelector("#side-menu > div:nth-child(3) > ul:nth-child(1) > li > a")).click();
	}

	public static void Security() {
		General.driver.findElement(By.cssSelector("#side-menu > div:nth-child(8) > ul:nth-child(1) > li > a")).click();
	}

	public static void ClickBranches() {
		General.driver.findElement(By.linkText("Branches")).click();
	}

	public static void ClickUsers() {
		General.driver.findElement(By.linkText("Users")).click();
	}

	public static void SelectBranch(String BranchName) {
		WebElement table = General.driver.findElement(By.cssSelector("#list-wrapper > table"));
		List<WebElement> TR = table.findElements(By.tagName("tr"));
		for (int i = 1; i < TR.size(); i++) {
			List<WebElement> TD = TR.get(i).findElements(By.tagName("td"));
			// System.out.print(BranchName);
			if (TD.get(1).getText().equalsIgnoreCase(BranchName)) {
				TD.get(i).click();
				break;
			}
		}
	}

	public static void ClickCounter() {
		General.driver.findElement(By.id("BranchCounters")).click();
	}

	public static void CreateNewCounter() {
		General.driver.findElement(By.id("Create")).click();
	}

	public static void CreateNewUser() {
		General.driver.findElement(By.id("Create")).click();
	}

	public static void CounterName1(String BranchName1) {
		General.driver.findElement(By.id("CounterEntity_Name_L1")).sendKeys(BranchName1);
	}

	public static void CounterName2(String BranchName2) {
		General.driver.findElement(By.id("CounterEntity_Name_L2")).sendKeys(BranchName2);
	}

	public static void CounterName3(String BranchName3) {
		General.driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		if (General.driver.findElements(By.id("CounterEntity_Name_L3")).size() !=0) {
			General.driver.findElement(By.id("CounterEntity_Name_L3")).sendKeys(BranchName3);
		}
		General.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void UserName1(String UserName1) {
		General.driver.findElement(By.id("UserEntity_Name_L1")).sendKeys(UserName1);
	}

	public static void UserName2(String UserName2) {
		General.driver.findElement(By.id("UserEntity_Name_L2")).sendKeys(UserName2);
	}

	public static void UserName3(String UserName3) {
		General.driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		if (General.driver.findElements(By.id("UserEntity_Name_L3")).size() !=0) {
			General.driver.findElement(By.id("UserEntity_Name_L3")).sendKeys(UserName3);
		}
		General.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void LoginName(String LoginName) {
		General.driver.findElement(By.id("UserEntity_LoginName")).sendKeys(LoginName);
	}

	public static void Password() {
		General.driver.findElement(By.id("UserEntity_Password")).sendKeys("1234");
	}

	public static void ConfirmPassword() {
		General.driver.findElement(By.id("UserEntity_PasswordConfirmation")).sendKeys("1234");
	}

	public static void CounterNumber(int CounterNumber) {
		General.driver.findElement(By.id("CounterEntity_Number")).clear();
		General.driver.findElement(By.id("CounterEntity_Number")).sendKeys(String.valueOf(CounterNumber));
	}

	public static void CounterTitle(String CounterTitle) {
		General.driver.findElement(By.id("CounterEntity_ScreenTitle")).sendKeys(CounterTitle);
	}

	public static void AllocatedHall(String HallName) throws Exception {
		General.driver
				.findElement(By.cssSelector(
						"#panelBody > div:nth-child(2) > div.ibox-content > div:nth-child(3) > div > input"))
				.sendKeys(HallName);

	}

	public static void ClickSave() {
		General.driver
				.findElement(By.cssSelector("#panelBody > div.panel-footer.clearfix > div > div:nth-child(1) > button"))
				.click();
	}
}
