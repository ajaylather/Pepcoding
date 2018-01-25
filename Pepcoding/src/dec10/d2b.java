package dec10;

import java.util.Scanner;

public class d2b {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number in decimal format");
		int src = scn.nextInt();
		int dest = 0;

		int srcb = 10;
		int srcbkipower = 1; // represents 10 ki power 0
		int db = 2;

		while (src != 0) {
			int rem = src % db;
			int quo = src / db;

			dest += rem * srcbkipower;

			srcbkipower *= srcb; // preparing the power for next rem
			src = quo;
		}

		System.out.println(dest);
	}

}
