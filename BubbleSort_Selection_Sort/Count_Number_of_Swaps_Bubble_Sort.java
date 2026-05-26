package Java.BubbleSort_Selection_Sort;

public class Count_Number_of_Swaps_Bubble_Sort {

	public static void main(String[] args) {
		int arr[] = {4, 3, 2, 1};
		int count = 0;
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					count++;
				}
			}
		}
		System.out.println("Array:");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\nSwap Count: " + count);
	}

}
