package dec22;

import java.util.Scanner;

public class Sqrt {

	public static void main(String[] args) {
		// int n = 2;
		// int p = 4;
		//
		// int counter = 1;
		// double inc = 1;
		// double sqrt = 0;
		// double lo = 0;
		// double hi = n;
		//
		// int ipow = 1;
		// double dpow = 1;
		//
		// while(counter <= p + 1){
		// while(true){
		// sqrt = (lo + hi) / 2;
		//
		// if(sqrt * sqrt <= n && (sqrt + inc) * (sqrt + inc) > n){
		// break;
		// } else if(sqrt * sqrt > n){
		// hi = sqrt;
		// } else {
		// lo = sqrt;
		// }
		// }
		//
		// ipow *= 10;
		// dpow *= 10;
		// inc = inc * 0.1;
		// counter++;
		// }
		//
		// ipow /= 10;
		// dpow /= 10;
		//
		//
		// System.out.println(Math.round(sqrt * ipow) / dpow);

		int[] arr = takeInput();
		display(arr);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println(".");
	}

	static Scanner scn = new Scanner(System.in);

	public static int[] takeInput() {
		int[] arr = null;

		System.out.println("Enter the size of array ");
		int sz = scn.nextInt();

		arr = new int[sz];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the " + i + "th element of array ");
			arr[i] = scn.nextInt();
		}

		return arr;
	}

}
