package testCases;

import java.net.MalformedURLException;
import com.sedco.CVM.General;
import cvmServer.HomePage;
import cvmServer.LoginPage;

public class Try3Times {
	public static void main (String[] args) throws MalformedURLException {
		
		int x=1;
		int y=4;
		while (x<y) {
			try {
				General.openBrowser("chrome");
				General.navigate("http://10.0.0.155:8080/CVMServer");
				for (int i=1;i<5;i++) {
					LoginPage.EnterUsername("root");
					LoginPage.EnterPassword("root2");
					LoginPage.ClickLogin();
					HomePage.QueuingAndRouting();

					}
			}
			catch (Exception e) {
				General.closeBrowser();
				++x;
			}
		}
	}

}
