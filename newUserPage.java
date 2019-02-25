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

public class newUserPage {
    /**
     * constructs a new user page
     * params
     *    parent = parent JPanel to attach page to
     *    accounts = Hashtable of all the different accounts in system
     */
    private JPanel newuser, parent;
    private Hashtable accounts;
    private int frameBorderWE = 180;
    private int frameBorderNS = 200;
    private int fieldColumns = 25;
    private int vertGap = 20;
    private int gridColumn = 1;
    private int exclusiveBorderWE = 5;
    private int exclusiveBorderNS = 220;
    
    public JPanel newUserPage(final JPanel parent, final Hashtable accounts){
        this.parent = parent;
        this.accounts = accounts;
        newuser = new JPanel(new BorderLayout());
        newuser.setBorder(new EmptyBorder(frameBorderWE,frameBorderNS,frameBorderWE,frameBorderNS)); //top, left, bottom, right
        newuser.setBackground(Color.PINK);
        
        //create labels
        JLabel nameLabel = new JLabel("Enter name:");
        JLabel genderLabel = new JLabel("Enter gender(M/F):");
        JLabel ageLabel = new JLabel("Enter age:");
        JLabel pinLabel = new JLabel("Enter a 4-digit pin:");
        
        //create text fields
        final JFormattedTextField nameField = new JFormattedTextField(" ");
        nameField.setColumns(fieldColumns);
        final JFormattedTextField genderField = new JFormattedTextField(" ");
        final JFormattedTextField ageField = new JFormattedTextField(" ");
        final JFormattedTextField pinField = new JFormattedTextField(" ");
        
        //FORMATTED GRIDLAYOUT
        GridLayout gridlayout = new GridLayout(0,gridColumn);
        gridlayout.setVgap(vertGap);
            //Layout labels in a panel
            JPanel labelPane = new JPanel(gridlayout);
            labelPane.setBackground(Color.PINK);
            labelPane.add(nameLabel);
            labelPane.add(genderLabel);
            labelPane.add(ageLabel);
            labelPane.add(pinLabel);

            //Layout fields in a panel
            JPanel fieldPane = new JPanel(gridlayout);
            fieldPane.setBackground(Color.PINK);
            fieldPane.add(nameField);
            fieldPane.add(genderField);
            fieldPane.add(ageField);
            fieldPane.add(pinField);
        
        //Create button
        JButton enterButton = new JButton("Create Account");
            //JPanel exclusive for the create button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(exclusiveBorderWE, exclusiveBorderNS, exclusiveBorderWE, 0));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //creating non accessible final variables, new account, putting account in hash table
                     String tempname = nameField.getText();
                     String tempgender = genderField.getText();
                     int tempage = Integer.parseInt(ageField.getText());
                     int temppin = Integer.parseInt(pinField.getText());
                    Integer id = (int) (Math.random() * (9999-1000)) + 1000;//create a random number between 1-9999
                    customer temp = new customer(tempname, tempgender, tempage, id, temppin);
                    accounts.put(id, temp);
                    
                    //clear the text fields now
                    nameField.setText("");
                    genderField.setText("");
                    ageField.setText("");
                    pinField.setText("");
                    
                    JOptionPane.showMessageDialog(new JFrame(),
                         ("Your login is " + id + ". Please sign in now."));
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "loginPage");
                }
            });
        
        newuser.add(labelPane, BorderLayout.WEST);
        newuser.add(fieldPane, BorderLayout. EAST);
        newuser.add(exclusive, BorderLayout.SOUTH);
        
        return newuser;
    }
    
}
