package webCounterEmp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sedco.CVM.General;

public class MultiThreading {
	static int sum;
	public static WebDriver driver;

	public static int WaitingCustomers() {
		int wait = 0;
		WebElement table = driver.findElement(By.id("ServicesTable"));
		List<WebElement> TR = table.findElements(By.tagName("tr"));
		for (int i = 1; i < TR.size(); i++) {
			List<WebElement> TD = TR.get(i).findElements(By.tagName("td"));
			wait = Integer.parseInt(TD.get(1).getText());
			sum = sum + wait;
		}
		return sum;
	}

	public static void Next() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://10.0.0.231");
		driver.findElement(By.id("txtUsername")).sendKeys("root");
		driver.findElement(By.id("txtPassword")).sendKeys("sedco@123");
		driver.findElement(By.id("btnLogin")).click();

		WaitingCustomers();
		System.out.println(sum);
		try {
			while (0 < sum) {
				driver.findElement(By.id("btnNext")).click();
				General.waitFor(120);
				WaitingCustomers();
				System.out.println(sum);
			}
		} catch (Exception e) {
			driver.quit();
		}

		finally {
			driver.findElement(By.id("btnFinishMain")).click();
			driver.findElement(By.id("btnLogout")).click();
			driver.quit();
		}
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		class MyClass implements Runnable {
			public void run() {
				try {
					Next();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (int y = 0; y < 3; y++) {
			Thread T1 = new Thread(new MyClass());
			T1.start();
			Thread.sleep(5000);
		}
		/*
		 * Thread T2 = new Thread(new MyClass()); T2.start();
		 */
	}

}
