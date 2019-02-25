import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class menuPage {
    /**
     * constructs a new menu page
     * params
     *    parent = parent JPanel to attach page to
     */
    private JPanel menu, parent;
    private int frameBorderGaps = 30;
    private int frameBorder = 100;
    private int exclusiveBorderWE = 5;
    private int exclusiveBorderNS = 220;
    private int columns = 2;
    
    public JPanel menuPage(final JPanel parent){
        this.parent = parent;
        BorderLayout borderlayout = new BorderLayout();
        borderlayout.setHgap(frameBorderGaps);
        borderlayout.setVgap(frameBorderGaps);
        menu = new JPanel(borderlayout);
        menu.setBackground(Color.PINK);
        menu.setBorder(new EmptyBorder(frameBorder, frameBorder, frameBorder, frameBorder));
        
        //create buttons
        JButton openAccount = new JButton("Open Account");
            openAccount.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "openAccountPage");
                }
            });
            
        JButton closeAccount = new JButton ("Close Account");
            closeAccount.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "closeAccountPage");
                }
            });
        JButton deposit = new JButton("Deposit");
            deposit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "depositPage");
                }
            });
        JButton withdraw = new JButton("Withdraw");
            withdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "withdrawPage");
                }
            });
        JButton transfer = new JButton("Transfer");
            transfer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "transferPage");
                }
            });
        JButton accountsummary = new JButton("Account Summary");
            accountsummary.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "accountSummaryPage");
                }
            });
            
        //exit button exclusive
        JButton exit = new JButton("Exit");
             //JPanel exclusive for the exit button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(exit, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new EmptyBorder(exclusiveBorderWE, exclusiveBorderNS, exclusiveBorderWE, exclusiveBorderNS));
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, "greetingPage");
                }
            });
        
        //Layout buttons in panel
        GridLayout gridlayout = new GridLayout(0,columns);
        gridlayout.setHgap(frameBorderGaps);
        gridlayout.setVgap(frameBorderGaps);
        JPanel menuField = new JPanel(gridlayout);
        menuField.setBackground(Color.PINK);
        menuField.add(openAccount);
        menuField.add(closeAccount);
        menuField.add(deposit);
        menuField.add(withdraw);
        menuField.add(transfer);
        menuField.add(accountsummary);
        
        menu.add(menuField, BorderLayout.CENTER);
        menu.add(exclusive, BorderLayout.SOUTH);
        
        return menu;
    }
}
