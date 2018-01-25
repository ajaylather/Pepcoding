package dec15;

import java.util.Scanner;

public class StuffWithArrays {

	public static void main(String[] args) {
		// int[] arr = takeInput();
		// display(arr);
		// int max = max(arr);
		// System.out.println(max);
		// System.out.println(linearSearch(arr, 55));
		//
		// display(arr);
		// reverse(arr);
		// display(arr);
		//
		// insertionSort(arr);
		// display(arr);

		// int[] arr = takeInput();
		// int[] inv = inverse(arr);
		// display(arr);
		// display(inv);

		int[] arr = takeInput();
		largestSumContiguousSubarray(arr);
		majorityElement(arr);
	}

	public static int[] takeInput() {
		int[] retVal = null;

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the size of array: ");
		int n = scn.nextInt();

		retVal = new int[n];
		for (int i = 0; i < retVal.length; i++) {
			System.out.println("Enter the " + i + "th element ");
			retVal[i] = scn.nextInt();
		}

		return retVal;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int max(int[] arr) {
		int retVal = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > retVal) {
				retVal = arr[i];
			}
		}

		return retVal;
	}

	public static int linearSearch(int[] arr, int val) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				return i;
			}
		}

		return -1;
	}

	public static void reverse(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			// activity starts
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}

			// activity end

			counter++;
		}
	}

	public static void selectionSort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			// activity starts
			for (int i = counter; i < arr.length; i++) {
				if (arr[i] < arr[counter - 1]) {
					int temp = arr[i];
					arr[i] = arr[counter - 1];
					arr[counter - 1] = temp;
				}
			}
			// activity end

			counter++;
		}
	}

	public static void insertionSort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = counter; i > 0; i--) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				} else {
					break;
				}
			}
			counter++;
		}
	}

	public static int[] inverse(int[] arr) {
		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;
	}

	public static void largestSumContiguousSubarray(int[] arr) {
		int omax = arr[0], cmax = arr[0];
		int osp = 0, csp = 0;
		int oep = 0, cep = 0;

		for (int i = 1; i < arr.length; i++) {
			if (cmax + arr[i] < arr[i]) {
				cmax = arr[i];
				csp = cep = i;
			} else {
				cmax += arr[i];
				cep++;
			}

			if (cmax > omax) {
				omax = cmax;
				osp = csp;
				oep = cep;
			}
		}

		for (int i = osp; i <= oep; i++) {
			System.out.print(arr[i] + " + ");
		}
		System.out.println(". = " + omax);
	}

	public static void majorityElement(int[] arr) {
		int pmaj = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == pmaj) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				pmaj = arr[i];
				count = 1;
			}
		}

		count = 0;
		for (int val : arr) {
			if (val == pmaj) {
				count++;
			}
		}

		if (count > arr.length / 2) {
			System.out.println(pmaj);
		} else {
			System.out.println("No majority element.");
		}
	}

}
