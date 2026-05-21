/*Create an Employee class where each object gets 
 * a unique ID using constructor.*/

package Java.OOPS.Constructors;
class Employee{
	static int counter = 1000;
	int id;
	String name;
	
	Employee(String name) {
		this.name = name;
		id = ++counter;
	}
	
	void display() {
		System.out.println("ID: "+ id + " Name: " + name);
	}
}

public class Employee_Object_with_Auto_ID {
	public static void main(String[] args) {
		Employee e1 = new Employee("Arif");
		Employee e2 = new Employee("Gulam");
		e1.display();
		e2.display();
	}

}
