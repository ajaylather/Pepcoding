package dec8;

import java.util.Scanner;

public class lec1_1_5_5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number of rows");
		int num = scn.nextInt();

		int val = 1;
		int row = 1;
		while (row <= num) {
			int col = 1;
			while (col <= row) {
				System.out.print(val + " ");
				val++;
				col++;
			}

			System.out.println();
			row++;
		}
	}

}
