package Java.Exception_Handling;

public class Multiple_Catch_Blocks {
	public static void main(String[] args) {
		int arr[] = {1,2,3};
		int a = 8, b = 0;
		try {
			System.out.println(arr[5]); //Error
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Out Of Range.");
		}try {
			System.out.println("Result: " + a/b); //Error
		}catch(ArithmeticException e) {
			System.out.println("Can't Divide By Zero.");
		}
		
   }
}
