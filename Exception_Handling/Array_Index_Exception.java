package Java.Exception_Handling;

public class Array_Index_Exception {
	public static void main(String[] args) {
		int arr[] = {1,2};
		try {
			System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Index Out Of Bond");
		}

	}

}
