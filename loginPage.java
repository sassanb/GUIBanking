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

public class loginPage {
    /**
     * constructs a login page
     * params
     *    parent = parent JPanel to attach page to
     *    accounts = Hashtable of all the different accounts in system
     */
    private JPanel login,parent;
    private Hashtable accounts;
    private int frameBorderWE = 210;
    private int frameBorderNS = 200;
    private int fieldColumns = 25;
    private int vertGap = 20;
    private int exclusiveBorderWE = 5;
    private int exclusiveBorderNS = 220;
    
        public JPanel loginPage(final JPanel parent, final Hashtable accounts){
        //create the layout
        this.parent = parent;    
        this.accounts = accounts;
        login = new JPanel(new BorderLayout());
        login.setBorder(new EmptyBorder(frameBorderWE,frameBorderNS,frameBorderWE,frameBorderNS)); //top, left, bottom, right
        login.setBackground(Color.PINK);
        
        //create labels
        JLabel loginLabel = new JLabel("Login:");
        JLabel passLabel = new JLabel("Pin:");
        
        //create text fields
        final JFormattedTextField loginField = new JFormattedTextField(" ");
        loginField.setColumns(fieldColumns);
        final JFormattedTextField passField = new JFormattedTextField(" ");
        
        //FORMATTED GRIDLAYOUT
        GridLayout gridlayout = new GridLayout(0,1);
        gridlayout.setVgap(vertGap);
            //Layout labels in a panel
            JPanel labelPane = new JPanel(gridlayout);
            labelPane.setBackground(Color.PINK);
            labelPane.add(loginLabel);
            labelPane.add(passLabel);

            //Layout fields in a panel
            JPanel fieldPane = new JPanel(gridlayout);
            fieldPane.setBackground(Color.PINK);
            fieldPane.add(loginField);
            fieldPane.add(passField);
        
        //Enter button
        JButton enterButton = new JButton("Sign In");
            //JPanel exclusive for the enter button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(exclusiveBorderWE, exclusiveBorderNS, exclusiveBorderWE, 0));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final Integer templogin = Integer.parseInt(loginField.getText());
                    final int temppin = Integer.parseInt(passField.getText());
                    final customer hello = (customer)accounts.get(templogin);
                    
                    if(accounts.containsKey(templogin) == false){ //if the account doesnt exist
                        JOptionPane.showMessageDialog(new JFrame(),
                        "Your account does not exist.");
                    }
                    
                    else if(hello.pin == temppin){//if both login + pass is correct
                        CardLayout cl = (CardLayout)(parent.getLayout());
                        cl.show(parent, "menuPage");
                    }
                    
                    else { //if account exists, but wrong pass
                        JOptionPane.showMessageDialog(new JFrame(),
                         "Incorrect Pin.");
                    }
                }
            });
        
        login.add(labelPane, BorderLayout.WEST);
        login.add(fieldPane, BorderLayout. EAST);
        login.add(exclusive, BorderLayout.SOUTH);
        
        return login;
    }
    
}
