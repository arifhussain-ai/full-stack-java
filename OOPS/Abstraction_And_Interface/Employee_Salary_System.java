/*Create abstract class Employee with method calculateSalary().
Implement FullTimeEmployee and PartTimeEmployee.*/

package Java.OOPS.Abstraction_And_Interface;

abstract class Employee{
	abstract double calculateSalary();	
}

class FullTimeEmployee extends Employee{
	double calculateSalary() {
		return 50000;
	}	
}

class PartTimeEmployee extends Employee{
	double calculateSalary() {
		return 20000;
	}	
}

public class Employee_Salary_System {
	public static void main(String[] args) {
		Employee E;
		
		E = new PartTimeEmployee();
		System.out.println("Part Time Employee: " + E.calculateSalary());
		
		E = new FullTimeEmployee();
		System.out.println("Full Time Employee: " + E.calculateSalary());
	}
}
