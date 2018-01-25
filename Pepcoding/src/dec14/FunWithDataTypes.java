package dec14;

public class FunWithDataTypes {

	public static void main(String[] args) {
		// Part 1
		byte by = 10;
		short sh = 20;
		int in = 30;
		long lo = 40;

		// by = sh;
		// by = in;
		// by = lo;

		// sh = by;
		// sh = in;
		// sh = lo;

		// Part 2
		by = 10; // by = (byte)10;
		by = 127;
		// by = 128;
		by = (byte) -400;
		System.out.println(by);

		// by = -128;
		// while(by <= 127){
		// System.out.println(by);
		// by++;
		// }

		// System.out.println(isTheBitSet(-200, 5));
		// printAllBits(-200);
		// System.out.println(getTheRightMostSetBit(-200));
		// int maskrm = getTheRightMostSetBitSmarter(-200);
		// System.out.println(maskrm);
		// printAllBits(maskrm);

		// Part 3
		System.out.println(10000000000L);
		in = (int) 10000000000L;
		System.out.println(in);

		// Part 4
		// float fl = 5.5;
		float fl = 5.5f;
		double db = 5.5;

		// fl = db;
		db = fl;

		in = (int) fl;
		fl = in;

		// Part 7
		char ch = 'a';
		System.out.println(ch);
		ch = 97;
		System.out.println(ch);
		ch = (char) 65633;
		System.out.println(ch);

		in = ch;
		// ch = in;
		ch = (char) in;
		// ch = ch + 1;
		ch = (char) (ch + 1);

		// Part 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
	}

	public static boolean isTheBitSet(int num, int bitIdx) {
		int mask = 1 << bitIdx;
		int test = num & mask;
		if (test == 0) {
			return false;
		} else {
			return true;
		}
	}

	// public static int setTheBit(int num, int bitIdx){
	//
	// }
	//
	public static void printAllBits(int num) {
		for (int bitidx = 31; bitidx >= 0; bitidx--) {
			boolean res = isTheBitSet(num, bitidx);
			if (res == true) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
		System.out.println();
	}

	public static int getTheRightMostSetBit(int num) {
		int retval = -1;

		for (int bitidx = 0; bitidx <= 31; bitidx++) {
			boolean res = isTheBitSet(num, bitidx);
			if (res == true) {
				retval = bitidx;
				break;
			}
		}

		return retval;
	}

	public static int getTheRightMostSetBitSmarter(int num) {
		return num & -num;
	}

	public static void printCase(char ch) {

	}
}
