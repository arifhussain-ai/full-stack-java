package Java.Nested_Try_Catch;

public class Nested_try_with_finally {
	public static void main(String[] args) {
		try {
			try {
				int a = 9/0;
			}catch(ArithmeticException e) {
				System.out.println("Inner Error Handling");
			}finally {
				System.out.println("Inner Finally");
			}
			
		}catch(Exception e) {
			System.out.println("Outer Error Handling");
		}finally {
			System.out.println("Outer Finally");
		}

	}

}
