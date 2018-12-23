package newQS;

import com.sedco.CVM.General;
import com.sedco.CVM.MainPage;

public class NewQueuingService {
	public static void main (String[] args) throws Exception {
		
		General.openBrowser("chrome");
		General.navigate("http://10.0.0.125:3000/");
		MainPage.SelectBranch();
		MainPage.ClickConnect();
		General.waitFor(5);
		General.closeBrowser();
	}
	

}
