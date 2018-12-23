package testCases;

import javax.swing.*;

public class Multiple {
   public static void main(String[] args) {
      JTextField Field1 = new JTextField(30);
      JTextField Field2 = new JTextField(30);
      JTextField Field3 = new JTextField(30);

      JPanel myPanel = new JPanel();
      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
      myPanel.add(new JLabel("Server URL:"));
      myPanel.add(Field1);
      myPanel.add(Box.createHorizontalStrut(0)); // a spacer
      myPanel.add(new JLabel("Branch Number:"));
      myPanel.add(Field2);
      myPanel.add(Box.createHorizontalStrut(0)); // a spacer
      myPanel.add(new JLabel("Number:"));
      myPanel.add(Field3);
      
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter Your Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
    	 String server = Field1.getText();
         System.out.println(server);
         String Branch = Field2.getText();
         System.out.println(Branch);
         String User = Field3.getText();
         System.out.println(User);
         
      }
   }
}