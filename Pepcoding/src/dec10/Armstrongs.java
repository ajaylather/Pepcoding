package dec10;

import java.util.Scanner;

public class Armstrongs {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the smaller number ");
		int sn = scn.nextInt();

		System.out.println("Enter the larger number ");
		int ln = scn.nextInt();

		printArmstrongs(sn, ln);
	}

	public static boolean IsArmstrong(int n) {
		int sum = 0;
		int originaln = n;

		while (n != 0) {
			int rem = n % 10;
			int quo = n / 10;

			sum += rem * rem * rem;

			n = quo;
		}

		if (sum == originaln) {
			return true;
		} else {
			return false;
		}
	}

	public static void printArmstrongs(int sn, int ln) {
		for (int i = sn; i <= ln; i++) {
			boolean isiarmstrong = IsArmstrong(i);
			if (isiarmstrong == true) {
				System.out.println(i);
			}
		}
	}

}
