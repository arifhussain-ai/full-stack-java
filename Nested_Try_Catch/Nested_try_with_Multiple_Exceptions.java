/*Handle string and arithmetic exception using nested try.*/

package Java.Nested_Try_Catch;

public class Nested_try_with_Multiple_Exceptions {
	public static void main(String[] args) {
		try {
			try {
				String s = null;
				System.out.println("Length of string: " + s.length());
			}catch(NullPointerException e) {
				System.out.println("Inner: Null Error");
			}
			int a = 12/0;
		}catch (ArithmeticException e){
			System.out.println("Outer: Cannot Divde By Zero");
		}

	}

}
