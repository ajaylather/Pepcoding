package dec8;

import java.util.Scanner;

public class lec1_1_5_7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");
		int n = scn.nextInt();

		int row = 0;
		int val = 1;
		while (row < n) {
			int col = 0;
			val = 1;

			while (col <= row) {
				System.out.print(val);
				int ncval = (val * (row - col)) / (col + 1);
				val = ncval;
				col++;
			}

			row++;
			System.out.println();
		}
	}

}
