package dec20;

import java.util.Scanner;

public class StuffWithStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String str = scn.nextLine();
		printChars(str);
		printAllSubstrings(str);
	}

	public static void printChars(String str) {

	}

	public static void printAllSubstrings(String str) {
		for (int sp = 0; sp < str.length(); sp++) {
			for (int ep = sp + 1; ep <= str.length(); ep++) {
				System.out.println(str.substring(sp, ep));
			}
		}
	}

	public static boolean IsPalindrome(String str) {
		int li = 0, ri = str.length() - 1;

		while (li < ri) {
			if (str.charAt(li) == str.charAt(ri)) {
				li++;
				ri--;
			} else {
				return false;
			}
		}

		return true;
	}

}
