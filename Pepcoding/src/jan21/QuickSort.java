package jan21;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 55, 11, 2, 120, 33, 100, 77 };
		int[] arr1 = {10,20};
		Quick_Sort(arr1, 0, arr1.length - 1);
		display(arr1);
	}

	public static void Quick_Sort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int left = low;
		int right = high;
		int mid = (low + high) / 2;
		int pivot = arr[mid];
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		Quick_Sort(arr, low, right);
		Quick_Sort(arr, left, high);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
