package testCases;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sedco.CVM.General;

import cvmServer.HomePage;
import cvmServer.LoginPage;

public class CreateCounters {

	public static void main(String[] args) throws Exception {

		JTextField ServerURLBox = new JTextField(30);
		JTextField FirstIndexBox = new JTextField(10);
		JTextField LastIndexBox = new JTextField(10);
		JTextField BranchNameBox = new JTextField(10);
		JTextField HallNameBox = new JTextField(10);

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
		myPanel.add(Box.createHorizontalStrut(0)); // a spacer
		myPanel.add(new JLabel("Branch Name:"));
		myPanel.add(BranchNameBox);
		myPanel.add(Box.createHorizontalStrut(0)); // a spacer
		myPanel.add(new JLabel("Hall Name:"));
		myPanel.add(HallNameBox);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Your Values",
				JOptionPane.OK_CANCEL_OPTION);
		String server = ServerURLBox.getText();
		String FirstIndex = FirstIndexBox.getText();
		String LastIndex = LastIndexBox.getText();
		String BranchName = BranchNameBox.getText();
		String HallName = HallNameBox.getText();

		if (result == JOptionPane.OK_OPTION) {

			General.openBrowser("chrome");
			General.navigate(server);
			LoginPage.EnterUsername("root");
			LoginPage.EnterPassword("root");
			LoginPage.ClickLogin();
			HomePage.QueuingAndRouting();

			try {
				for (int i = Integer.parseInt(FirstIndex); i <= Integer.parseInt(LastIndex); i++) {
					HomePage.ClickBranches();
					HomePage.SelectBranch(BranchName);
					HomePage.ClickCounter();
					HomePage.CreateNewCounter();
					HomePage.AllocatedHall(HallName);
					HomePage.CounterName1("Counter" + i);
					HomePage.CounterName2("Counter" + i);
					HomePage.CounterName3("Counter" + i);
					HomePage.CounterNumber(i);
					HomePage.CounterTitle("Counter" + i);
					HomePage.ClickSave();
					General.waitFor(2);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				General.closeBrowser();
			}

			finally {
				General.closeBrowser();
			}
		}
	}
}
