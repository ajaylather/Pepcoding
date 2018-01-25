package dec22;

import java.util.Scanner;

public class StuffWithSB {

	public static void main(String[] args) {
		// System.out.println("Enter a string");
		//
		// Scanner scn = new Scanner(System.in);
		// String str = scn.nextLine();
		//
		// String toggled = toggleCase(str);
		// System.out.println(toggled);
		//
		// String modify2 = modify2("adxyw");
		// System.out.println(modify2);

		printSS("abcd");
	}

	private static String toggleCase(String str) {
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < str.length(); i++) {
			char oc = str.charAt(i);
			char nc = ' ';

			if (oc >= 'a' && oc <= 'z') {
				nc = (char) (oc - 'a' + 'A');
			} else if (oc >= 'A' && oc <= 'Z') {
				nc = (char) (oc - 'A' + 'a');
			} else {
				nc = oc;
			}

			// sb.append(nc);
			sb.setCharAt(i, nc);
		}

		return sb.toString();
	}

	private static String modify1(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char oc = str.charAt(i);
			char nc = ' ';

			if (i % 2 == 0) {
				nc = (char) (oc - 1);
			} else {
				nc = (char) (oc + 1);
			}

			sb.append(nc);
		}

		return sb.toString();
	}

	private static String modify2(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length() - 1; i++) {
			char ch1 = str.charAt(i);
			char ch2 = str.charAt(i + 1);
			int gap = ch2 - ch1;

			sb.append(ch1);
			sb.append(gap);
		}

		sb.append(str.charAt(str.length() - 1));

		return sb.toString();
	}

	private static String compress1(String str) {
		StringBuilder sb = new StringBuilder();

		int counter = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				counter++;
			} else {
				sb.append(str.charAt(i));
				counter = 1;
			}
		}

		sb.append(str.charAt(str.length() - 1));

		return sb.toString();
	}

	private static String compress2(String str) {
		StringBuilder sb = new StringBuilder();

		int counter = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				counter++;
			} else {
				sb.append(str.charAt(i));
				sb.append(counter);
				counter = 1;
			}
		}

		sb.append(str.charAt(str.length() - 1));
		if (counter > 1) {
			sb.append(counter);
		}

		return sb.toString();
	}

	private static void printSS(String str) {
		int limit = 1 << str.length();

		int counter = 0;
		while (counter < limit) {
			System.out.println(counter);

			for (int i = 0; i < str.length(); i++) {
				int ithBitKaMask = 1 << (str.length() - 1 - i);
				if ((ithBitKaMask & counter) != 0) { // ith bit is on in counter
					System.out.print(str.charAt(i));
				}
			}

			System.out.println();
			counter++;
		}
	}

}
