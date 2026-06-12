package Java.Nested_Try_Catch;

import java.util.Scanner;

class MyException extends Exception{
	public MyException(String msg) {
		super(msg);
	}
}

public class Nested_try_with_Custom_Exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a age: ");
		int age = sc.nextInt();
		try {
			if(age < 18) {
				throw new MyException("Not Eligable");
			}else {
				System.out.println("Eligable");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

}
