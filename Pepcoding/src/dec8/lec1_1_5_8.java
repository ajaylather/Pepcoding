package dec8;

import java.util.Scanner;

public class lec1_1_5_8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");
		int n = scn.nextInt();

		int row = 1;
		int nsp = n - 1;
		int nst = 1;
		int val = 1;
		while (row <= n) {
			val = row;

			// work for spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print("  ");
				csp++;
			}

			// work for stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + " ");
				val = cst <= nst / 2 ? val + 1 : val - 1;
				cst++;
			}

			// prep for next row
			nsp--;
			nst += 2;

			row++;
			System.out.println();
		}
	}

}
