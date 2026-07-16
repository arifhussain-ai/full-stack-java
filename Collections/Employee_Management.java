package Java.Collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	private int id;
	private String name;
	private String department;
	private int sal;
	
	public Employee(int id, String name, String department, int sal) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.sal = sal;
	}
	
	public int getSalary() {
		return sal;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String toString() {
		return "ID: "+id+"| Name: "+name+"| Department: "+department+"| Salary: $"+ sal;
	}
}
public class Employee_Management {

	public static void main(String[] args) {
	 	List<Employee> employee = Arrays.asList(
	 			new Employee(101, "Arif", "CEO", 900000),
	 			new Employee(102, "Gulam", "Finance", 89000),
	 			new Employee(104, "Vivek", "Manager", 71000),
	 			new Employee(103, "Krishna", "HR", 50000)
	 			);
	 	
	 	List<Employee> HighSalaryEmployee = employee.stream()
	 			                             .filter(emp->
	 			                             emp.getSalary() >= 70000)
	 			                             .collect(Collectors.toList());
	 	
	 	System.out.println("\t======High Salary Employees======");
	 	HighSalaryEmployee.forEach(System.out::println);
	}
}
