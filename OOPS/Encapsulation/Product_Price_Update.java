/*Create a Product class 
 * where price can only increase (not decrease).*/

package Java.OOPS.Encapsulation;

class Price{
	private double price;
	
	public void setPrice(double price) {
		if (price > this.price) {
			this.price = price;
		}else {
			System.out.println("Price Can't Decrease.");
		}
	}
	
	public double getPrice() {
		return price;
	}
}

public class Product_Price_Update {
	public static void main(String[] args) {
		Price p = new Price();
		p.setPrice(1000);
		p.setPrice(1100);
		System.out.println("Price: " + p.getPrice());

	}

}
