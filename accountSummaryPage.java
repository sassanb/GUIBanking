import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;


public class accountSummaryPage {
    private JPanel summary, parent;
    private final int BORDER_TOP = 100;
    private final int BORDER_LEFT = 100;
    private final int BORDER_BOTTOM = 100;
    private final int BORDER_RIGHT = 100;
    private final int EMPTY_BORDER_TOP = 5;
    private final int EMPTY_BORDER_LEFT = 0;
    private final int EMPTY_BORDER_BOTTOM = 5;
    private final int EMPTY_BORDER_RIGHT = 0;
    private final String EXIT_BUTTON_LABEL = "EXIT";
    private final int TEXT_ARER_WIDTH = 200;
    private final int TEXT_ARER_HEIGHT = 200;
    private final String MENU_PAGE = "menuPage";
    
    public JPanel accountSummaryPage(final JPanel parent, ArrayList<account> accounts ){
        this.parent = parent;        
        summary = new JPanel(new BorderLayout());
        summary.setBackground(Color.PINK);
        summary.setBorder(new EmptyBorder(BORDER_TOP, BORDER_LEFT, BORDER_BOTTOM, BORDER_RIGHT));
        
        // This text area will contain the accounts summary
        final JTextArea textArea = new JTextArea(TEXT_ARER_WIDTH, TEXT_ARER_HEIGHT);
        String output = "";
        for (int i = 0; i < accounts.size(); i++ ) 
        {    
            output = output + "\nAccount:"+accounts.get(i).getAccountNumber()+
                " Balance: "+ accounts.get(i).getBalance(); 
        }
        textArea.setText( output );
         
         //Create button
        JButton enterButton = new JButton(EXIT_BUTTON_LABEL);
            //JPanel exclusive for the create button...
            JPanel exclusive = new JPanel(new BorderLayout());
            exclusive.add(enterButton, BorderLayout.SOUTH);
            exclusive.setBackground(Color.PINK);
            exclusive.setBorder(new 
                EmptyBorder(EMPTY_BORDER_TOP, EMPTY_BORDER_LEFT, EMPTY_BORDER_BOTTOM, EMPTY_BORDER_RIGHT));
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                   
                    CardLayout cl = (CardLayout)(parent.getLayout());
                    cl.show(parent, MENU_PAGE);
                }
            });
            
        summary.add(exclusive, BorderLayout.SOUTH);       
        summary.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return summary;
    }
}
