/*Write a program using nested try-catch where:
Outer block handles arithmetic error
Inner block handles array error*/

package Java.Nested_Try_Catch;

public class Basic_Nested_Try_Catch {
	public static void main(String[] args) {
		try {
			int a = 2;
			int b = 0;
			int d = a/b;
			try {
				int arr[] = {1,2,3};
			}catch(ArithmeticException e){
				System.out.println("Inner: Array Out Of Bond");
			}
		}catch(ArithmeticException e){
			System.out.println("Outer: Arthmetic Error");
		}
	}
}
