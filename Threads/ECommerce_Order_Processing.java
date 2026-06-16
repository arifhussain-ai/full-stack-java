package Java.Threads;

class PaymentSerivce extends Thread{
	private String odrId;
	private double amt;
	
	public PaymentSerivce(String odrId, double amt) {
		this.odrId = odrId;
		this.amt = amt;
	}
	
	public void run() {
		try {
			System.out.println("=========================");
			System.out.println("Order Id: " + odrId);
			System.out.println("Amount: $"+amt);
			
			System.out.println("Verfy Payment Details....");
			Thread.sleep(2000);
			
			System.out.println("Connecting Payment Gateway....");
			Thread.sleep(3000);
			
			System.out.println("Payment Sucessfull....");
			System.out.println("=========================");
		}catch(InterruptedException e){
			System.out.println("Payment Interrupted....");
		}
	}
}

public class ECommerce_Order_Processing {
	public static void main(String[] args) throws InterruptedException {
		PaymentSerivce payment = new PaymentSerivce("ORD1001", 25000.00);
		payment.start();
		
		//Wait for payment confirm
		payment.join();
		
		System.out.println("\nOrder Confirmed....");
		System.out.println("Invoice Created....");
		System.out.println("Order Shipped....");
	}

}
