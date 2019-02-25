
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Manipulating the task of transfer amount specified by user from one account to another
 * 
 */

public class transferPage {
    JPanel transfer, parent;
    private final int BORDER_TOP = 170;
    private final int BORDER_LEFT = 190;
    private final int BORDER_BOTTOM = 200;
    private final int BORDER_RIGHT = 160;
    private final int EMPTY_BORDER_TOP = 5;
    private final int EMPTY_BORDER_LEFT = 220;
    private final int EMPTY_BORDER_BOTTOM = 5;
    private final int EMPTY_BORDER_RIGHT = 10;
    private final String FROM_LABEL = "FROM:";
    private final String TO_LABEL = "TO:";
    private final String AMOUNT_LABEL = "AMOUNT:";
    private String[] accountType = {"Checking", "Savings"};
    private final String COMFIRM_BUTTON_LABEL = "Confirm:";
    private final String BACK_BUTTON_LABEL = "Back:";
    private final int GRID_LAYOUT_GAP = 20;
    private final int GRID_LAYOUT_ROW = 0;
    private final int GRID_LAYOUT_COLUMN = 1;
    private final String MENU_PAGE = "menuPage";
    private final String ACCOUNT_SUMMARY_PAGE = "accountSummaryPage";
    
    public JPanel transferPage(final JPanel parent){
        this.parent = parent;        
        transfer = new JPanel(new BorderLayout());
        transfer.setBorder(new EmptyBorder(BORDER_TOP,BORDER_LEFT,BORDER_BOTTOM,BORDER_RIGHT)); 
        transfer.setBackground(Color.PINK);
        
         //create labels
        JLabel fromLabel = new JLabel(FROM_LABEL);
        JLabel toLabel = new JLabel(TO_LABEL);
        JLabel amountLabel = new JLabel(AMOUNT_LABEL);
        
        //create text fields
        final JFormattedTextField balanceField = new JFormattedTextField();
        balanceField.setColumns(25);

        //create combo box
        final JComboBox accounts = new JComboBox(accountType);
        final JComboBox accounts2 = new JComboBox(accountType);
        
        //FORMATTED GRIDLAYOUT
        GridLayout gridlayout = new GridLayout(GRID_LAYOUT_ROW, GRID_LAYOUT_COLUMN);
        gridlayout.setVgap(GRID_LAYOUT_GAP);
            //Layout labels in a panel
            JPanel labelPane = new JPanel(gridlayout);
            labelPane.setBackground(Color.PINK);
            labelPane.add(fromLabel);
            labelPane.add(toLabel);
            labelPane.add(amountLabel);

            //Layout fields in a panel
            JPanel fieldPane = new JPanel(gridlayout);
            fieldPane.setBackground(Color.PINK);
            fieldPane.add(accounts);
            fieldPane.add(accounts2);
            fieldPane.add(balanceField);
            
        //BACK BUTTON
        JButton backButton = new JButton(BACK_BUTTON_LABEL);
            //JPanel exclusive for the create button...
            JPanel exclusive2 = new JPanel(new BorderLayout());
            exclusive2.add(backButton, BorderLayout.NORTH);
            exclusive2.setBackground(Color.PINK);
            exclusive2.setBorder(new EmptyBorder(EMPTY_BORDER_TOP, EMPTY_BORDER_LEFT, EMPTY_BORDER_BOTTOM, EMPTY_BORDER_RIGHT));
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, MENU_PAGE);
                }
            });            
            
        //Create button
        JButton enterButton = new JButton(COMFIRM_BUTTON_LABEL);
            //JPanel exclusive for the create button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(EMPTY_BORDER_TOP, EMPTY_BORDER_LEFT, EMPTY_BORDER_BOTTOM, EMPTY_BORDER_RIGHT));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                   
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    
                    //get source account from select of first ComboBox
                    account sourceAccount = (account) accounts.getSelectedItem();
                    
                    //get target account from select of second ComboBox
                    account targetAccount = (account) accounts2.getSelectedItem();

                    //get transfer amount from TextField balanceField
                    Integer amount = (Integer)balanceField.getValue();
                    
                    sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                    targetAccount.setBalance(targetAccount.getBalance() + amount);

                    cl.show(parent, ACCOUNT_SUMMARY_PAGE);
                }
            });
            
        transfer.add(exclusive2, BorderLayout.NORTH);    
        transfer.add(labelPane, BorderLayout.WEST);
        transfer.add(fieldPane, BorderLayout.EAST);
        transfer.add(exclusive, BorderLayout.SOUTH);  
        
        return transfer;
    }
}
