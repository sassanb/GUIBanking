import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class depositPage {
    private JPanel deposit, parent;
    private Hashtable accounts;
    private int TOP = 200;
    private int LEFT = 190;
    private int BOTTOM = 200;
    private int RIGHT = 190;
    private int COLUMN = 25;
    private int X_LAYOUT = 0;
    private int Y_LAYOUT = 1;
    private int GAP = 20;
    private int BACK_TOP = 5;
    private int BACK_LEFT = 0;
    private int BACK_BOTTOM = 5;
    private int BACK_RIGHT = 300;
    private int CONFIRM_TOP = 5;
    private int CONFIRM_LEFT = 220;
    private int CONFIRM_BOTTOM = 5;
    private int CONFIRM_RIGHT = 0;
    
    public JPanel depositPage(final JPanel parent,final Hashtable accounts){
    	/**
    	 Constructs a a parent.
    	 @param parent the item to be deposited
    	 @param account the account deposit
    	 */
    	this.parent = parent;     
        this.accounts = accounts;
        deposit = new JPanel(new BorderLayout());
        deposit.setBorder(new EmptyBorder(TOP, LEFT, BOTTOM, RIGHT)); 
        deposit.setBackground(Color.PINK);
        
        /**
        @param Labels the Amount 
        @param Labels the Account 
        @param Labels the Confirm 
        */
         //create labels
        JLabel accountLabel = new JLabel("Account:");
        JLabel balanceLabel = new JLabel("Amount:");
        JLabel idLabel = new JLabel ("Confirm ID");
        JLabel depositLabel = new JLabel ("Amount You Want to Deposit");
        
       
        /**
        @param Formats the balance in text field.
        @param Formats the id in text field.
        @param Formats the deposit in text field.
       */
        //create text fields
        final JFormattedTextField balanceField = new JFormattedTextField(" ");
        balanceField.setColumns(COLUMN);
        final JFormattedTextField idField = new JFormattedTextField(" ");
        final JFormattedTextField depositField = new JFormattedTextField(" ");
        //create combo box
        String[] accountNames = {"Checking", "Savings"};
        final JComboBox accounts1 = new JComboBox(accountNames);
        
        /**
        @param add label in JPanel
       */
        //FORMATTED GRIDLAYOUT
        GridLayout gridlayout = new GridLayout(X_LAYOUT,Y_LAYOUT);
        gridlayout.setVgap(GAP);
            //Layout labels in a panel
            JPanel labelPane = new JPanel(gridlayout);
            labelPane.setBackground(Color.PINK);
            labelPane.add(accountLabel);
            labelPane.add(balanceLabel);
            labelPane.add(idLabel);
            labelPane.add(depositLabel);
            //Layout fields in a panel
            JPanel fieldPane = new JPanel(gridlayout);
            fieldPane.setBackground(Color.PINK);
            fieldPane.add(accounts1);
            fieldPane.add(balanceField);
            fieldPane.add(idField);
            fieldPane.add(depositField);
        /**
        @param add button in JButton
        @param add action listener
        */   
        //BACK BUTTON
        JButton backButton = new JButton("Back");
            //JPanel exclusive for the create button...
            JPanel exclusive2 = new JPanel(new BorderLayout());
            exclusive2.add(backButton, BorderLayout.NORTH);
            exclusive2.setBackground(Color.PINK);
            exclusive2.setBorder(new EmptyBorder(BACK_TOP, BACK_LEFT, BACK_BOTTOM, BACK_RIGHT));
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	  String tempaccounts = (String)accounts1.getSelectedItem();
                      String tempid = idField.getText();
                      double tempbalance = Double.parseDouble(balanceField.getText());
                	  double tempdeposit = Double.parseDouble(depositField.getText());
                      customer hello = (customer)accounts.get(tempid);
                     
                     if(tempaccounts.equals("Checking")){
                    	 hello.accounts.get(1).depositBalance(tempbalance);
                    	 
                    	 JOptionPane.showMessageDialog(new JFrame(),
                    			 "Your new " + tempaccounts + " balance is" + hello.accounts.get(0).balance);
                     }
                     
                     else if(tempaccounts.equals("Savings")){
                    	 hello.accounts.get(1).depositBalance(tempbalance);
                    	 
                    	 JOptionPane.showMessageDialog(new JFrame(),
                    			 "Your new " + tempaccounts + " balance is" + hello.accounts.get(1).balance);
                     }
                     
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "menuPage");
                }
            });
        /**
        @param add button in JButton
        @param set JPanel in border layout
        */       
        //Create button
        JButton enterButton = new JButton("Confirm");
            //JPanel exclusive for the create button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(CONFIRM_TOP, CONFIRM_LEFT, CONFIRM_BOTTOM, CONFIRM_RIGHT));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "accountSummaryPage");
                }
            });
       /**
       @param add border layout
       @return deposit
       */   
        deposit.add(exclusive2, BorderLayout.NORTH);
        deposit.add(labelPane, BorderLayout.WEST);
        deposit.add(fieldPane, BorderLayout. EAST);
        deposit.add(exclusive, BorderLayout.SOUTH);    
        
        return deposit;
        
    }
}
