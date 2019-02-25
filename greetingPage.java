import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class greetingPage {
    /**
     * constructs a greeting page
     * params
     *    parent = parent JPanel to attach page to
     *    accounts = Hashtable of all the different accounts in system
     */
    private int frameBorderWE = 180;
    private int frameBorderNS = 220;
    JPanel greeting, parent;
    Hashtable accounts;
    
    public JPanel greetingPage(final JPanel parent, final Hashtable accounts){
        this.parent = parent;
        this.accounts = accounts;
        GridLayout gridlayout = new GridLayout(0,1);
        gridlayout.setVgap(20);
        greeting = new JPanel(gridlayout);
        greeting.setBorder(new EmptyBorder(frameBorderWE,frameBorderNS,frameBorderNS,frameBorderNS));
        greeting.setBackground(Color.PINK);
       
        JLabel greetingLabel = new JLabel("Welcome to the Self Services Banking System! - Main Menu");
        JButton newUser = new JButton("New user?");  
            newUser.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cl = (CardLayout)(parent.getLayout());
                        cl.show(parent, "newUserPage");
                    }
                });
        JButton customerButton = new JButton("Customer Login");
            customerButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cl = (CardLayout)(parent.getLayout());
                        cl.show(parent, "loginPage");
                    }
                });
        
        greeting.add(greetingLabel);
        greeting.add(newUser);
        greeting.add(customerButton);
        
        return greeting;
    }
}
