import java.util.ArrayList;

/* constructs a new customer object
 * @@params
 *    id = key
 *    name = customer name
 *    gender = customer gender
 *    age = customer age
 *    pin = customer pin
 */
public class customer {
    String name, gender;
    String status = "active";
    int age, id, pin;
    ArrayList<account> accounts = new ArrayList<account>();
    
    public customer(String name, String gender, int age, int id, int pin){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.pin = pin;
        this.id = id;
      /*Integer number = accounts.size()+1;  
        addAccount(new account(number, 0, "Checking"));
         number = accounts.size()+1;
        addAccount(new account(number, 0, "Savings"));*/
    }
    
    public void addAccount(account a){
        this.accounts.add(a);
           
    }
    
    public int getPin(){
        return pin;
    }
}
