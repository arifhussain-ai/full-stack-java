/*Create a class with method add() to add:
two integers
three integers.*/

package Java.OOPS.Polymorphism;

class Calculator{
	int add(int a, int b) {
		 return a+b;
	}
	
	int add(int a, int b , int c) {
		return a+b+c;
	}
}

public class Method_Overloading_Compile_time_Polymorphism {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("Add: "+c.add(7, 3));
		System.out.println("Add: "+c.add(7, 3, 5));

	}

}
