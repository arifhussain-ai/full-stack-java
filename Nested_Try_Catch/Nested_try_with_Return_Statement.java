/*What happens when return is used inside nested try/finally?*/

package Java.Nested_Try_Catch;

public class Nested_try_with_Return_Statement {
	static int test() {
		try{
			try {
				return 1;
		}finally {
			System.out.println("Inner Finally");
		}
	}finally {
		System.out.println("Outer Finally");
	}
}

	public static void main(String[] args) {
		System.out.println(test());
		
	}

}
