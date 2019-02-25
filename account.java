/* constructs a new account object
 * @@params
 *    number = random number for account
 *    balance = the amount of money inside the account
 *    type = checking/savings
 *    status = active/inactive
 */
public class account {
    int number, balance;
    String type;
    boolean status = true;
    
    public account(int number, int balance, String type){
        this.number = number;  //unique
        this.balance = balance;
        this.type = type; 
    }
    
    public void depositBalance(double a){
    	balance += a;
    }
    
    public void withdrawBalance(double a) {
    	balance -= a;
    }
    
    public void statuschange(){
    	status = false;
    }
    
    public int getBalance(){
    	return balance;
    }
    
    public void setBalance(double bal){
    	this.balance = (int) bal;
    }
    
    public int getAccountNumber()
    {
    	return number;
    }
}