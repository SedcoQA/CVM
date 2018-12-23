package testCases;

import java.net.MalformedURLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sedco.CVM.General;

import cvmServer.HomePage;
import cvmServer.LoginPage;

public class CreateUsers {

	public static void main(String[] args) throws MalformedURLException {

		JTextField ServerURLBox = new JTextField(30);
		JTextField FirstIndexBox = new JTextField(10);
		JTextField LastIndexBox = new JTextField(10);

		JPanel myPanel = new JPanel();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(new JLabel("Server URL:"));
		myPanel.add(ServerURLBox);
		myPanel.add(Box.createHorizontalStrut(0)); // a spacer
		myPanel.add(new JLabel("First counter index:"));
		myPanel.add(FirstIndexBox);
		myPanel.add(Box.createHorizontalStrut(0)); // a spacer
		myPanel.add(new JLabel("Last counter index:"));
		myPanel.add(LastIndexBox);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Your Values",
				JOptionPane.OK_CANCEL_OPTION);
		String server = ServerURLBox.getText();
		String FirstIndex = FirstIndexBox.getText();
		String LastIndex = LastIndexBox.getText();

		if (result == JOptionPane.OK_OPTION) {
			General.openBrowser("chrome");
			General.navigate(server);
			LoginPage.EnterUsername("root");
			LoginPage.EnterPassword("root");
			LoginPage.ClickLogin();
			HomePage.Security();
			for (int i = Integer.parseInt(FirstIndex); i <= Integer.parseInt(LastIndex); i++) {
				try {
					HomePage.ClickUsers();
					HomePage.CreateNewUser();
					HomePage.UserName1("User" + i);
					HomePage.UserName2("User" + i);
					HomePage.UserName3("User" + i);
					HomePage.LoginName("User" + i);
					HomePage.Password();
					HomePage.ConfirmPassword();
					HomePage.ClickSave();
					General.waitFor(2);
				} catch (Exception e) {
					e.printStackTrace();
					General.closeBrowser();
				}
			}
			General.closeBrowser();
		}
	}
}
