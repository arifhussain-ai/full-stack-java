package Java.Threads;

public class ATM_Transaction extends Thread {
	
	private String acc_num;
	private double amt;
	
	public ATM_Transaction(String acc_num, double amt) {
		this.acc_num = acc_num;
		this.amt = amt;
	}

	public void run() {
		try {
			 System.out.println("================================");
			 System.out.println("ATM Transcation Started....");
			 System.out.println("Account Number: " + acc_num);
			 System.out.println("Amount: $"+amt);
			 
			 System.out.println("Verify Account.....");
			 Thread.sleep(2000);
			 
			 System.out.println("Checking Amount....");
			 Thread.sleep(2000);
			 
			 System.out.println("Processing Amount....");
			 Thread.sleep(3000);
			 
			 System.out.println("Cash Dispensed Successfully");
			 System.out.println("Transcation Completed.....");
			 System.out.println("================================");
			 
		}catch(InterruptedException e) {
			System.out.println("Transaction Interrupted");
		}
	}	
	public static void main(String[] args) throws Exception {
		ATM_Transaction transcation = new ATM_Transaction("4646464654684",1000000.00);
		System.out.println("Before transcation state: " + transcation.getState());
		
		transcation.start();
		
		System.out.println("After transcation state: " + transcation.getState());
		
		Thread.sleep(1000);
		
		System.out.println("Current transcation state: " + transcation.getState());
		transcation.join();
		
		System.out.println("Final state: " + transcation.getState());
	}
}
