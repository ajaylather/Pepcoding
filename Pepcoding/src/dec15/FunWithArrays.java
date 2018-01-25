package dec15;

public class FunWithArrays {

	public static void main(String[] args) {
		int[] arr;

		arr = new int[3];
		System.out.println(arr);

		// Part 1 - get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		// System.out.println(arr[3]);

		// Part 2 - set
		arr[0] = 10;
		arr[1] = 30;
		arr[2] = 20;
		// arr[3] = 40;

		// Part 3 - loop
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// Swap primitives - not works
		// int ii = 10;
		// int jj = 20;
		// System.out.println(ii + ", " + jj);
		// swapPrimitives(ii, jj);
		// System.out.println(ii + ", " + jj);

		// swap in non-primitives - works
		// int ii = 0;
		// int jj = 2;
		// System.out.println(arr[ii] + ", " + arr[jj]);
		// swapNonPrimitive(arr, ii, jj);
		// System.out.println(arr[ii] + ", " + arr[jj]);

		// test swap knowledge 1 - did not work
		// int ii = 0;
		// int jj = 2;
		// System.out.println(arr[ii] + ", " + arr[jj]);
		// swapNonPrimitiveTest1(arr[ii], arr[jj]);
		// System.out.println(arr[ii] + ", " + arr[jj]);

		// test swap knowledge 2
		int[] one = { 10, 20, 30 };
		int[] two = { 30, 20, 10 };
		System.out.println(one[0] + ", " + one[2]);
		swapNonPrimitiveTest2(one, two);
		System.out.println(one[0] + ", " + one[2]);
	}

	private static void swapNonPrimitiveTest2(int[] one, int[] two) {
		System.out.println(one[0] + ", " + one[2]);
		int[] temp = one;
		one = two;
		two = temp;
		System.out.println(one[0] + ", " + one[2]);
	}

	public static void swapNonPrimitiveTest1(int i, int j) {
		System.out.println(i + ", " + j);
		int temp = i;
		i = j;
		j = temp;
		System.out.println(i + ", " + j);
	}

	private static void swapNonPrimitive(int[] arr, int i, int j) {
		System.out.println(arr[i] + ", " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		System.out.println(arr[i] + ", " + arr[j]);
	}

	public static void swapPrimitives(int i, int j) {
		System.out.println(i + ", " + j);
		int temp = i;
		i = j;
		j = temp;
		System.out.println(i + ", " + j);
	}

}
