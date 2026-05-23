/*Create a Payment class and subclasses UPI and Card 
 * with method pay().*/

package Java.OOPS.Polymorphism;

class Payment{
	void pay() {
		System.out.println("Payment Processing.");
	}
}

class UPI extends Payment{
	void pay() {
		System.out.println("Payment using UPI.");
	}
}

class Card extends Payment{
	void pay() {
		System.out.println("Payment using Card.");
	}
}

public class Payment_System {
	public static void main(String[] args) {
		Payment p;
		
		p = new UPI();
		p.pay();
		p = new Card();
		p.pay();

	}

}
