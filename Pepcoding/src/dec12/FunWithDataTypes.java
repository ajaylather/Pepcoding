package dec12;

public class FunWithDataTypes {

	public static void main(String[] args) {
		// Part 1
		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// by = sh;
		// by = in;
		// by = lo;

		// sh = by;
		// sh = in;
		// sh = lo;

		// in = by;
		// in = sh;
		// in = lo;

		// long mei sab aa jaenge

		// Part 2
		by = 10; // by = (byte)10;
		by = 127;
		// by = 128;
		by = (byte) -300;
		// System.out.println(by);

		// Part 3
		// in = 10000000000;
		System.out.println(10000000000L);
		lo = 10000000000L;
		in = (int) 10000000000L;

		// Part 4
		// float fl = 5.5;
		float fl = 5.9f;
		double db = 5.5;

		// fl = db;
		db = fl;

		// Part 5
		// in = fl;
		in = (int) fl;
		fl = in;

		// Part 7
		char ch = 'a';
		ch = 97;
		ch = (char) (65535 + 98);
		System.out.println(ch);

		in = ch;
		// ch = in;
		ch = (char) in;

		in = ch + 2;
		// ch = ch + 2;
		ch = (char) (ch + 2);

		// Part 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
	}

}
