package dec8;

import java.util.Scanner;

public class lec1_1_5_9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");
		int n = scn.nextInt();

		int row = 1;
		int nsp = n / 2;
		int nst = 1;
		int val = 1;
		while (row <= n) {
			if (row <= n / 2 + 1) {
				val = row;
			} else {
				val = n + 1 - row;
			}

			// work for spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// work for stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val);
				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}
				cst++;
			}

			// prep for next row
			if (row <= n / 2) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}

			row++;
			System.out.println();
		}
	}

}
