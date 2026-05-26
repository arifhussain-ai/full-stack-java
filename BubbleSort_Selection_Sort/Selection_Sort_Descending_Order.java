package Java.BubbleSort_Selection_Sort;

public class Selection_Sort_Descending_Order {

	public static void main(String[] args) {
		int arr[] = {64, 25, 12, 22, 11};
		int n = arr.length;
		for(int i = 0; i < n-1; i++) {
			int maximum = i;
			for (int j = i+1; j<n; j++) {
				if (arr[maximum] < arr[j]) {
					maximum = j;
				}
			}
			int temp = arr[maximum];
			arr[maximum] = arr[i];
			arr[i] = temp;
		}
		
		System.out.println("Descending Order Selection Sort:");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
