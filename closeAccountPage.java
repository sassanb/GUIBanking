import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class closeAccountPage {
    private JPanel closeaccount,parent;
    private Hashtable accounts;
    
    public JPanel closeAccountPage(final JPanel parent, final Hashtable accounts){
        this.parent = parent;        
        this.accounts = accounts;
        closeaccount = new JPanel(new BorderLayout());
        closeaccount.setBorder(new EmptyBorder(200,200,250,180)); //top, left, bottom, right
        closeaccount.setBackground(Color.PINK);
        
        //create labels
        JLabel passLabel = new JLabel("Password:");
        
        //create text fields
        JFormattedTextField passField = new JFormattedTextField(" ");
        passField.setColumns(25);
        
        //FORMATTED GRIDLAYOUT
        GridLayout gridlayout = new GridLayout(0,1);
        gridlayout.setVgap(50);
            //Layout labels in a panel
            JPanel labelPane = new JPanel(gridlayout);
            labelPane.setBackground(Color.PINK);
            labelPane.add(passLabel);

            //Layout fields in a panel
            JPanel fieldPane = new JPanel(gridlayout);
            fieldPane.setBackground(Color.PINK);
            fieldPane.add(passField);
        
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
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "menuPage");
                }
            });    
            
        //Enter button
        JButton enterButton = new JButton("Confirm");
            //JPanel exclusive for the enter button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(5, 220, 5, 0));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(new JFrame(),
                         "Your account has closed.");
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "greetingPage");
                }
            });
        
        closeaccount.add(exclusive2, BorderLayout.NORTH);
        closeaccount.add(labelPane, BorderLayout.WEST);
        closeaccount.add(fieldPane, BorderLayout.EAST);
        closeaccount.add(exclusive, BorderLayout.SOUTH);
        
        return closeaccount;
    }
}
