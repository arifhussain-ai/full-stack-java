/*Create an interface PaymentGateway with method pay().
Implement UPI, Card, and NetBanking.*/

package Java.OOPS.Abstraction_And_Interface;

interface PaymentGateway{
	void pay(double amount);
}

class UPI implements PaymentGateway{
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using UPI.");
	}
}

class Card implements PaymentGateway{
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Card.");
	}
}

class NetBanking implements PaymentGateway{
	public void pay(double amount){
		System.out.println("Paid " + amount + " using Netbanking");
	}
} 

public class Payment_Gateway_System {
	public static void main(String[] args) {
		PaymentGateway p;
		
		p = new UPI();
		p.pay(2000);
		p = new Card();
		p.pay(20000);
		p = new NetBanking();
		p.pay(50000);

	}

}
