package assignments;

import java.util.Scanner;

public class Recursion_4_Arrays {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		// System.out.println(checksortsi(arr,0));
		// System.out.println(checksortli(arr, arr.length-1));
		// System.out.println(check_pal(arr, 0, arr.length-1));
		inverse(arr,0);
		display(arr);
	}

	// Check starting from first index
	public static boolean checksortsi(int[] arr, int si) {
		if (si == arr.length - 1)
			return true;
		if (arr[si] > arr[si + 1]) {
			return false;
		}
		boolean chk = checksortsi(arr, si + 1);
		return chk;
	}

	// Check starting from last index
	public static boolean checksortli(int[] arr, int lidx) {
		if (lidx == 0) {
			return true;
		}
		if (arr[lidx - 1] > arr[lidx]) {
			return false;
		}
		boolean chk1 = checksortli(arr, lidx - 1);
		return chk1;
	}

	public static boolean check_pal(int[] arr, int start, int end) {
		if (arr.length == 0 || arr.length == 1) {
			return true;
		}
		if (start >= end) {
			return true;
		}
		if (arr[start] != arr[end]) {
			return false;
		}
		boolean chk = check_pal(arr, start + 1, end - 1);
		return chk;
	}

	public static void reverse(int[] arr, int start, int end) {
		if (arr.length == 0 || arr.length == 1) {
			return;
		}
		if (start >= end) {
			return;
		}
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverse(arr, start+1, end-1);
	}
	public static void inverse(int[] arr, int i) {
		if (i == arr.length) {
			return;
		}
		int temp=arr[i];
		inverse(arr, i+1);
		arr[temp] = i;
	}
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		System.out.print("swapped "+ a+","+b);
	}
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
