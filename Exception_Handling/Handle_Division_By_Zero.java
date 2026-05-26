package Java.Exception_Handling;

public class Handle_Division_By_Zero {
	public static void main(String[] args) {
		int a = 9, b = 0;
		try {
			int result = a/b;
			System.out.println("RESULT: " + result);
		}catch (ArithmeticException e) {
			System.out.println("Can't Divide By Zero.");
		}
	}

}
