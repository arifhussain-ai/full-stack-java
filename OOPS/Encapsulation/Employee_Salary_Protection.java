/*Create an Employee class where salary cannot be negative.*/

package Java.OOPS.Encapsulation;

class Emp_Salary{
	private double salary;
	
	public void setSalary(double salary) {
		if (salary >= 0) {
			this.salary = salary;
		}else {
			System.out.println("Salary Cant Be Negative.");
		}
	}
	
	public double getSalary() {
		return salary;
	}
}
public class Employee_Salary_Protection {
	public static void main(String[] args) {
		Emp_Salary e = new Emp_Salary();
		e.setSalary(80000);
		System.out.println("Salary: " + e.getSalary());

	}

}
