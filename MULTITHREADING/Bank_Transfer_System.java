package Java.MULTITHREADING;
class BankAccount{
	private final String accountNumber;
	
	public BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}

public class Bank_Transfer_System {
	public static void main(String[] args) {
		BankAccount accountA = new BankAccount("ACC-101");
		BankAccount accountB = new BankAccount("ACC-102");
		
		Thread transfer1 = new Thread(() -> {
			synchronized (accountA) {
				System.out.println(Thread.currentThread().getName() + " locked " 
			+ accountA.getAccountNumber());
				try {
					Thread.sleep(1000);
				}catch (Exception e) {}
				System.out.println(Thread.currentThread().getName() + " locked " +
				accountB.getAccountNumber());
				 System.out.println("Transfer A -> B Successful");
			}
		},"Transfer-Thread-1");
		Thread transfer2 = new Thread(() -> {
			synchronized (accountB) {
				System.out.println(Thread.currentThread().getName() + " locked " +
			accountB.getAccountNumber());
				try {
					Thread.sleep(1000);
				}catch (Exception e) {}
				System.out.println(Thread.currentThread().getName() + " locked " +
				accountA.getAccountNumber());
				System.out.println("Transfer B -> A Sucessful");
			}
		},"Transfer-Thread-2");
		transfer1.start();
		transfer2.start();
	}
}
