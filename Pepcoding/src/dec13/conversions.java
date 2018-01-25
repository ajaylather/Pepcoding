package dec13;

import java.util.Scanner;

public class conversions {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// System.out.println("Enter the decimal number ");
		// int dec = scn.nextInt();
		//
		// System.out.println("Enter the destination base ");
		// int db = scn.nextInt();
		//
		// int dest = decimaltoab(dec, db);
		// System.out.println(dest);
		System.out.println("Enter the source number ");
		int sn = scn.nextInt();

		System.out.println("Enter the source base ");
		int sb = scn.nextInt();

		int dec = abtodecimal(sn, sb);
		System.out.println(dec);
	}

	public static int decimaltoab(int dec, int db) {
		int dn = 0;
		int sb = 10;
		int sbkipower = 1;
		while (dec != 0) {
			int rem = dec % db;
			int quo = dec / db;

			dn = dn + rem * sbkipower;
			sbkipower = sbkipower * sb;

			dec = quo;
		}

		return dn;
	}

	public static int abtodecimal(int sn, int sb) {
		int dn = 0;
		int db = 10;
		int sbkipower = 1;
		while (sn != 0) {
			int rem = sn % db;
			int quo = sn / db;

			dn = dn + rem * sbkipower;
			sbkipower = sbkipower * sb;

			sn = quo;
		}

		return dn;
	}

	public static int abtoab(int sn, int sb, int db) {
		int dec = abtodecimal(sn, sb);
		int dn = decimaltoab(dec, db);
		return dn;
	}
}
