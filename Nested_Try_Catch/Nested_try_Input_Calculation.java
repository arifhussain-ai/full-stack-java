/*Take user input and divide numbers using nested try:
Inner handles invalid input
Outer handles divide by zero*/

package Java.Nested_Try_Catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Nested_try_Input_Calculation {
	public static void main(String[] args) {
		try {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter a num1: ");
				int a = sc.nextInt();
				System.out.print("Enter a num2: ");
				int b = sc.nextInt();
				System.out.println("Result: " + a/b);
				
			}catch(InputMismatchException e) {
				System.out.println("Invail Input...");
			}
		}catch(ArithmeticException e) {
			System.out.println("Cannot divide by zero...");
		}

	}

}
