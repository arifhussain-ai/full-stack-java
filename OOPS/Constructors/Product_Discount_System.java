/*Create a Product class 
 * where constructor applies discount if price > 1000.*/

package Java.OOPS.Constructors;

class Product{
	String name;
	double price;
	
	Product(String name,double price){
		this.name = name;
		
		if (price > 1000) {
			this.price = price * 0.9;
		}else {
			this.price = price;
		}
	}
	
	void display() {
		System.out.println("Product: "+ name + ", "+
				" Price: " + price);
	}
}
public class Product_Discount_System {
	public static void main(String[] args) {
		Product p = new Product("Laptop",2000);
		p.display();
	}

}
