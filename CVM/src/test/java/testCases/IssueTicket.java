package testCases;

import com.sedco.CVM.General;
import com.sedco.CVM.MainPage;

public class IssueTicket {
	public static void main (String[] args) throws Exception {
		
		General.openBrowser("chrome");
		General.navigate("http://10.0.0.125:3000/");
		MainPage.SelectBranch();
		MainPage.ClickConnect();
		MainPage.IssueSingleTicket();
		MainPage.EnterPassword("root");
		MainPage.LoginWithRoot();
		MainPage.Next();
		General.waitFor(5);
		MainPage.Next();
		General.waitFor(5);
		MainPage.RefreshStatistics();
		General.waitFor(5);
		General.closeBrowser();
	}

}
