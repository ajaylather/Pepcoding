package dec28;

public class RecursionWithArrays {

	public static void main(String[] args) {
		// int[] arr = {10, 20, 30};

		// int[] arr = null;
		//
		// arr = new int[3];
		// arr[0] = 100;
		// arr[1] = -50;
		// arr[2] = 30;

		// int one = 16;
		// int two = 20;
		//
		// System.out.println(one + ", " + two);
		// Swap(one, two);
		// System.out.println(one + ", " + two);

		// System.out.println(arr[0] + " " + arr[2]);
		// Swap(arr[0], arr[2]);
		// System.out.println(arr[0] + " " + arr[2]);

		int[] arr = { 55, 22, 88, 33, 11, 66 };
		display(arr, 0);
	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static void Swap(int[] arr, int i, int j) {
		System.out.println(arr[i] + " " + arr[j]);

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		System.out.println(arr[i] + " " + arr[j]);
	}

	public static void display(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		display(arr, vidx + 1);
	}

	public static void displayR(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		displayR(arr, vidx + 1);
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int maxisa = max(arr, vidx + 1);
		int maxifa = 0;

		if (maxisa > arr[vidx]) {
			maxifa = maxisa;
		} else {
			maxifa = arr[vidx];
		}

		return maxifa;
	}

	public static boolean find(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}

		if (arr[vidx] == data) {
			return true;
		}

		boolean foundinsa = find(arr, vidx + 1, data);
		return foundinsa;
	}

	public static int firstIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		}

		int fiinsa = firstIndex(arr, vidx + 1, data);
		return fiinsa;
	}

	public static int lastIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		int liinsa = lastIndex(arr, vidx + 1, data);
		if (liinsa != -1) {
			return liinsa;
		} else {
			if (arr[vidx] == data) {
				return vidx;
			} else {
				return -1;
			}
		}
	}
}
