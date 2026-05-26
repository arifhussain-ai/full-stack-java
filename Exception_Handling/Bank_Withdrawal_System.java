package Java.Exception_Handling;

class Bank{
	void withdrwal(int amount) {
		int balance = 10000;
		
		try {
			if (amount > balance) {
				throw new Exception("Insufficent Balance");
			}
			System.out.println("Scuessfully Withdrawal");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class Bank_Withdrawal_System {
	public static void main(String[] args) {
		Bank obj = new Bank();
		obj.withdrwal(9000);

	}

}
