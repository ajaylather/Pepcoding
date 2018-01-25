package dec13;

import java.util.Scanner;

public class d2b {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a decimal number ");

		int sn = scn.nextInt();
		int sb = 10;
		int dn = 0;
		int db = 2;

		int sbpowers = 1; // sb ^ 0

		while (sn != 0) {
			int quo = sn / db;
			int rem = sn % db;

			// System.out.println(rem + " to be multiplied with " + sbpowers);
			dn = dn + rem * sbpowers;
			sbpowers *= sb;

			sn = quo;
		}

		System.out.println(dn);
	}

}
