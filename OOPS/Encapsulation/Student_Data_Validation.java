/*Create a Student class with private marks. 
 * Allow setting marks only between 0–100.*/

package Java.OOPS.Encapsulation;

class Student{
	private int marks;
	
	public void setMarks(int m) {
		if (m >= 0 && m <= 100) {
			this.marks = m;
		}else {
			System.out.println("Invaild Marks");
		}
	}
	
	public int getMarks() {
		return marks;
	}
}
public class Student_Data_Validation {
	public static void main(String[] args) {
		Student s = new Student();
		s.setMarks(80);
		System.out.println("Marks: "+ s.getMarks());
	}

}
