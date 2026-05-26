package Java.Exception_Handling;

public class Finally_Block_Usage {
	public static void main(String[] args) {
		int a = 9, b= 0;
		try {
			int result = a/b;
			System.out.println(result);
		}catch (ArithmeticException e){
			System.out.println("Cannot divide by zero");
		}finally {
			System.out.println("Always Executed");
		}

	}

}
