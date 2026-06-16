package Java.MULTITHREADING;
class Bank_Account{
	@SuppressWarnings("unused")
	private String accountNumber;
	private double balance;
	
	public Bank_Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public synchronized void withdraw(double amount) {
		System.out.println(Thread.currentThread().getName() +
				" requesting withdrawal of ₹" + amount);
		if(balance >= amount){
			try {
				System.out.println(Thread.currentThread().getName() +
						" is processing transaction...");
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			balance -= amount;
			
			System.out.println(Thread.currentThread().getName() + " withdrawal successful");
			System.out.println("Available Balance : ₹"+balance);
		}else {
			System.out.println(Thread.currentThread().getName() + " Transaction Failed.");
			System.out.println("Insufficient Balance");
		}
	}	
}

public class Bank_system {
	public static void main(String[] args) {
		Bank_Account account = new Bank_Account("ACC101", 10000.00);
		Thread customer1 = new Thread(() -> account.withdraw(7000), "Customer-1");
		Thread customer2 = new Thread(() -> account.withdraw(4000), "Customer-2");
		
		customer1.start();
		customer2.start();
	}
}

