/*Create a Vehicle class with speed.
Create Car class that inherits it and adds brand.*/

package Java.OOPS.Inheritance;

class Speed{
	int speed = 120;
}

class Car extends Speed{
	String car = "Toyota";
	
	void display() {
		System.out.println("Brand: "+ car);
		System.out.println("Speed: "+ speed);
	}
}

public class Vehicle_System {
	public static void main(String[] args) {
		Car obj = new Car();
		obj.display();
	}

}
