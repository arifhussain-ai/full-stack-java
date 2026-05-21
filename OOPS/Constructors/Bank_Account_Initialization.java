/*Create a BankAccount class where constructor sets account holder name and balance. 
 * Balance should not be negative.*/

package Java.OOPS.Constructors;
class Bankdetails{
	String name;
	double balance;
	
	Bankdetails(String name, double balance) {
		this.name = name;
		
		if (balance >= 0 ) {
			this.balance = balance;
		}else {
			this.balance = 0;
		}
	}
	
	void display() {
		System.out.println("Name: "+name);
		System.out.println("Bank Balance: "+balance);
	}
}

public class Bank_Account_Initialization {
	public static void main(String[] args) {
		Bankdetails bank = new Bankdetails("Arif Khan", 8456466.85);
		bank.display();
	}

}
