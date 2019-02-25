import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class openAccountPage {
    private JPanel openaccount, parent;
    private Hashtable accounts;
    
    public JPanel openAccountPage(final JPanel parent, final Hashtable accounts){
        this.parent = parent;       
        this.accounts = accounts;
        openaccount = new JPanel(new BorderLayout());
        openaccount.setBorder(new EmptyBorder(200,190,200,190)); //top, left, bottom, right
        openaccount.setBackground(Color.PINK);
        
         //create labels
        JLabel accountLabel = new JLabel("Account Type:");
        JLabel balanceLabel = new JLabel("Enter initial balance:");
        
        //create text fields
        final JFormattedTextField balanceField = new JFormattedTextField(" ");
        balanceField.setColumns(25);

        //create combo box
        String[] accountNames = {"Checking", "Savings"};
        final JComboBox accounts1 = new JComboBox(accountNames);
        
        //FORMATTED GRIDLAYOUT
        GridLayout gridlayout = new GridLayout(0,1);
        gridlayout.setVgap(20);
            //Layout labels in a panel
            JPanel labelPane = new JPanel(gridlayout);
            labelPane.setBackground(Color.PINK);
            labelPane.add(accountLabel);
            labelPane.add(balanceLabel);

            //Layout fields in a panel
            JPanel fieldPane = new JPanel(gridlayout);
            fieldPane.setBackground(Color.PINK);
            fieldPane.add(accounts1);
            fieldPane.add(balanceField);
            
        //BACK BUTTON
        JButton backButton = new JButton("Back");
            //JPanel exclusive for the create button...
            JPanel exclusive2 = new JPanel(new BorderLayout());
            exclusive2.add(backButton, BorderLayout.NORTH);
            exclusive2.setBackground(Color.PINK);
            exclusive2.setBorder(new EmptyBorder(5, 0, 5, 300));
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	final int tempbalance = Integer.parseInt(balanceField.getText());
                	final String temptype = (String) accounts1.getSelectedItem();
                	Integer id = (int) (Math.random() * (9999-1000)) + 1000;
                	account temp = new account(id, tempbalance, temptype);//number, balance, type
                			
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "menuPage");
                }
            });    
            
        //Create button
        JButton enterButton = new JButton("Open Account");
            //JPanel exclusive for the create button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(5, 220, 5, 0));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                    JOptionPane.showMessageDialog(new JFrame(),
                         "Your account has been made!");
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "menuPage");
                }
            });
            
        openaccount.add(exclusive2, BorderLayout.NORTH);    
        openaccount.add(labelPane, BorderLayout.WEST);
        openaccount.add(fieldPane, BorderLayout. EAST);
        openaccount.add(exclusive, BorderLayout.SOUTH);
        
        return openaccount;
    }
}
