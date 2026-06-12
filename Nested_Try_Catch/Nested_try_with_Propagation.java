/*Demonstrate exception propagation using nested try.*/

package Java.Nested_Try_Catch;

public class Nested_try_with_Propagation {
	public static void main(String[] args) {
		try {
			try {
				int a = 10/0;
			}catch(NullPointerException e) {
				System.out.println("Inner Catch");
			}
		}catch(Exception e) {
			System.out.println("Outer Catch");
		}
	}
}
