package dec30_Recursion_ArrayList;

public class FunWithRecursionCtd {

	public static void main(String[] args) {
		int[] arr = { 33, 55, 11, 10, 55, 5, 55, 4, 55, 0 };
		// int[] result = allIndices(arr, 0, 555, 0);
		bubbleSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println(".");
	}

	public static void bubbleSort(int[] arr, int si, int li) {
		if (li == 0) {
			return;
		}

		if (si == li) { // we realise the largest of this journey (from 0 to li) is home
			// start the journey again from 0 to li - 1
			bubbleSort(arr, 0, li - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}
		bubbleSort(arr, si + 1, li);
	}

	public static void selectionSort(int[] arr, int si,int li) {
	    if(si==arr.length) {
	    	return;
	    }
	    if(li== arr.length) {
	    	selectionSort(arr, si+1, si+2);
	    	return;
	    }
	    if(arr[si]>arr[li]) {
	    	int temp=arr[si];
	    	arr[si]=arr[li];
	    	arr[li]=temp;
	    }
	    selectionSort(arr, si+1, li);
	}
}