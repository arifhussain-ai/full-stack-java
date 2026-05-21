/*Create a Student class where one student object 
 * copies another and adds bonus marks.*/

package Java.OOPS.Constructors;

class Student{
	String name;
	int marks;
	
	Student(int marks) {
		this.marks = marks;
	}
	
	Student(Student s){
		this.marks = s.marks + 5;
	}
	
	void display() {
		System.out.println("Marks: " + marks);
	}
}

public class Copy_Constructor_for_Student_Records {
	public static void main(String[] args) {
		Student s1 = new Student(90);
		Student s2 = new Student(s1);
		s1.display();
		s2.display();
	}

}
