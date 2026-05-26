package Java.BubbleSort_Selection_Sort;

public class Find_Kth_Smallest_Using_Selection_Sort_Logic {

	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 3,2, 20, 15};
		int k = 4;
		
		for (int i = 0; i < k; i++) {
			int smalllest = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[smalllest] > arr[j]) {
					smalllest = j;
				}
			}
			int temp = arr[smalllest];
			arr[smalllest] = arr[i];
			arr[i] = temp;
		}
		
		System.out.println("Kth Smallest: " + arr[k-1]);

	}

}
