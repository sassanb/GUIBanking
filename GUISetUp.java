import java.awt.CardLayout;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUISetUp {
    private JFrame main;
    private JPanel parent,greeting,login,menu,newuser,openaccount,closeaccount,deposit,withdraw,transfer,summary;
    private Hashtable<Integer, customer> accounts;
    
    private void initialSetUp() {
        /**
         * constructs a new JFrame for the banking system, with all the pages
         */
        //set up main JFrame
        main = new JFrame();
        main.setSize(800,600);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent = new JPanel(new CardLayout());
        accounts = new Hashtable<Integer, customer>();
        
        //set up greeting page
        greetingPage greetinginstance = new greetingPage();
        greeting = greetinginstance.greetingPage(parent, accounts);
        greeting.setVisible(true);
        
        //set up new user page
        newUserPage newuserinstance = new newUserPage();
        newuser = newuserinstance.newUserPage(parent,accounts);
        newuser.setVisible(true);
        
        //set up login page
        loginPage logininstance = new loginPage();
        login = logininstance.loginPage(parent, accounts);
        login.setVisible(true);
        
        //set up menu page
        menuPage menuinstance = new menuPage();
        menu = menuinstance.menuPage(parent);
        menu.setVisible(true);
        
        //set up openaccount page
        openAccountPage openaccountinstance = new openAccountPage();
        openaccount = openaccountinstance.openAccountPage(parent, accounts);
        openaccount.setVisible(true);
        
        //set up closeaccount page
        closeAccountPage closeaccountinstance = new closeAccountPage();
        closeaccount = closeaccountinstance.closeAccountPage(parent, accounts);
        closeaccount.setVisible(true);
        
        //set up deposit page
        depositPage depositinstance = new depositPage();
        deposit = depositinstance.depositPage(parent, accounts);
        deposit.setVisible(true);
        
        //set up withdraw page
        withdrawPage withdrawinstance = new withdrawPage();
        withdraw = withdrawinstance.withdrawPage(parent, accounts);
        withdraw.setVisible(true);
        
        //set up transfer page
        transferPage transferinstance = new transferPage();
 //       transfer = transferinstance.transferPage(parent, accounts);
        transfer.setVisible(true);
        
        //set up summary page
        accountSummaryPage summaryinstance = new accountSummaryPage();
   //     summary = summaryinstance.accountSummaryPage(parent, accounts);
        summary.setVisible(true);
        
        //set up parent JPanel that will hold the cards
        parent.add(greeting, "greetingPage");
        parent.add(newuser, "newUserPage");
        parent.add(login, "loginPage");
        parent.add(menu, "menuPage");
        parent.add(openaccount,"openAccountPage");
        parent.add(closeaccount,"closeAccountPage");
        parent.add(deposit, "depositPage");
        parent.add(withdraw, "withdrawPage");
        parent.add(transfer, "transferPage");
        parent.add(summary, "accountSummaryPage");
        
        main.add(parent);
        main.setVisible(true);
    }
    
    public static void main(String[] args) {
        GUISetUp tester = new GUISetUp();
        tester.initialSetUp();
    }
}
