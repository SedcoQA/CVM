package testCases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sedco.CVM.General;

public class MultiBrowsers {
	static int sum = 1;
	static int y = 1;
	// public static WebDriver driver[]= new ChromeDriver[5];

	public static void Next(WebDriver[] driver) throws MalformedURLException {

		driver[y] = new ChromeDriver();
		driver[y].manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver[y].manage().window().maximize();
		driver[y].get("http://10.0.0.");
		driver[y].findElement(By.id("txtUsername")).sendKeys("root");
		driver[y].findElement(By.id("txtPassword")).sendKeys("sedco@123");
		Select Counter = new Select(driver[y].findElement(By.id("ddlWindows")));
		Counter.selectByIndex(y - 1);
		driver[y].findElement(By.id("btnLogin")).click();
		WebElement table = (driver[y].findElement(By.id("ServicesTable")));
		WaitingCustomers(table);
		System.out.println(sum);

		try {
			while (sum > 0) {
				driver[1].findElement(By.id("btnNext")).click();
				WaitingCustomers(table);
				System.out.println(sum);
				General.waitFor(10);
			}
		} catch (Exception e) {
			driver[y].quit();
		}

		finally {
			driver[y].findElement(By.id("btnFinishMain")).click();
			driver[y].findElement(By.id("btnLogout")).click();
			driver[y].quit();
		}

	}

	public static int WaitingCustomers(WebElement table2) {
		int wait = 0;
		WebElement table = table2;
		List<WebElement> TR = table.findElements(By.tagName("tr"));
		for (int i = 1; i < TR.size(); i++) {
			List<WebElement> TD = TR.get(i).findElements(By.tagName("td"));
			wait = Integer.parseInt(TD.get(1).getText());
			sum = sum + wait;
		}
		return sum;
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		Runnable myrunnable = new Runnable() {
			public void run() {
				try {
					System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
					WebDriver driver[] = new ChromeDriver[50];
					Next(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		};
		for (y = 1; y < 3; y++) {
			new Thread(myrunnable).start();
			Thread.sleep(7000);
		}
	}
}
