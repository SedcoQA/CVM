package webCounterEmp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sedco.CVM.General;

public class MultipleWCE {
	static int sum;
	static int y = 1;
	public static WebDriver driver;
	public static WebDriver driver2;
	public static void WebDriver () {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.0.0.155");
	}
	
    
	public static int WaitingCustomers () {
	int wait = 0;
	WebElement table = driver.findElement(By.id("ServicesTable"));
	List <WebElement> TR = table.findElements(By.tagName("tr"));
	for (int i=1 ;i<TR.size();i++) {
		List <WebElement> TD = TR.get(i).findElements(By.tagName("td"));
		wait = Integer.parseInt(TD.get(1).getText());
		sum = sum+wait;
	}
	return sum;
	}
	
	public static void Next() throws MalformedURLException {
		WebDriver ();
		driver.findElement(By.id("txtUsername")).sendKeys("user"+y);
		driver.findElement(By.id("txtPassword")).sendKeys("1234");
		Select Counter = new Select (driver.findElement(By.id("ddlWindows")));
		Counter.selectByIndex(y-1);
		++y;
		driver.findElement(By.id("btnLogin")).click();
		WaitingCustomers ();
		System.out.println(sum);
		try {
			int i =0;
			while(i<=sum) {
				driver.findElement(By.id("btnNext")).click();
				General.waitFor(10);
				WaitingCustomers();
				System.out.println(sum);
			}
		}
		catch (Exception e) {
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
			public void run(){
					try {
						Next();
					} catch (MalformedURLException e) {
						e.printStackTrace();
						}
			   	}
			}
			for (int c=0;c<2;c++) {
		      Thread T1 = new Thread(new MyClass());
		      	T1.start();
		      	Thread.sleep(7000);
			}
/*				
			      Thread T2 = new Thread(new MyClass());
			      T2.start();*/
	}
}
