	/*Create a BankAccount class 
 * where withdrawal cannot exceed balance.*/

package Java.OOPS.Encapsulation;

class BankAcc{
	private double balance = 10000;
	
	public void withdrwal(double amount) {
		if (amount <= balance) {
			balance -= amount;
		}else {
			System.out.println("Insufficent Balance");
		}
	}
	
	public double getBalance() {
		return balance;
	}
}

public class Bank_Withdrawal_Limit {
	public static void main(String[] args) {
		BankAcc bank = new BankAcc();
		bank.withdrwal(9000);
		System.out.println("Current Balance: " +bank.getBalance());
	}
}
