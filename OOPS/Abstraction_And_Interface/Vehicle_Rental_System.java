/*Create abstract class Vehicle with method rentCost().
Implement Car and Bike.*/

package Java.OOPS.Abstraction_And_Interface;
abstract class Vehicle{
	abstract double rentCost(int day);
}

class Car extends Vehicle{
	double rentCost(int day) {
		return day * 1000;
	}
}

class Bike extends Vehicle{
	double rentCost(int day) {
		return day * 500;
	}
}

public class Vehicle_Rental_System {
	public static void main(String[] args) {
		Vehicle obj;
		
		obj = new Bike();
		System.out.println("Bike Rent: " + obj.rentCost(3));
		
		obj = new Car();
		System.out.println("Car Rent: " + obj.rentCost(3));
	}

}
