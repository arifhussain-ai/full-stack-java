package Java.Exception_Handling;

import java.util.Scanner;

class MyException extends Exception{
	MyException(String msg) {
		super(msg);
	}
}

public class Custom_Exception_Basic {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter a age: ");
			int age = sc.nextInt();
			
			if (age < 18) {
				throw new MyException("Not Eligible"); 
			}else {
				System.out.println("Eligilbe");
			}
		}catch(Exception e) {
				System.out.println(e.getMessage());
				
		}
	}

}
