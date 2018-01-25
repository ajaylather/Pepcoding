package dec12;

import java.util.Scanner;

public class printCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char ch = scn.next().charAt(0);
		printCase(ch);
	}

	private static void printCase(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			System.out.println("Lower");
		} else if (ch >= 'A' && ch <= 'Z') {
			System.out.println("Upper");
		} else {
			System.out.println("Invalid");
		}
	}

}
