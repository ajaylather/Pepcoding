package dec10;

public class Conversions {

	public static void main(String[] args) {
		int dn = abtoab(77, 8, 2);
		System.out.println(dn);
	}

	public static int abtodecimal(int sb, int sn) {
		int dest = 0;
		int db = 10;
		int srcbkipower = 1;

		while (sn != 0) {
			int rem = sn % db;
			int quo = sn / db;

			dest += rem * srcbkipower;
			srcbkipower *= sb;

			sn = quo;
		}

		return dest;
	}

	public static int decimaltoab(int db, int sn) {
		int dest = 0;
		int sb = 10;
		int srcbkipower = 1;

		while (sn != 0) {
			int rem = sn % db;
			int quo = sn / db;

			dest += rem * srcbkipower;
			srcbkipower *= sb;

			sn = quo;
		}

		return dest;
	}

	public static int abtoab(int sn, int sb, int db) {
		int dec = abtodecimal(sb, sn);
		int dest = decimaltoab(db, dec);
		return dest;
	}
}
