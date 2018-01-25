package dec10;

import java.util.Scanner;

public class ab2ab {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the source base:");
		int sb = scn.nextInt();

		System.out.println("Enter the source number: ");
		int src = scn.nextInt();

		System.out.println("Enter the destination base: ");
		int db = scn.nextInt();

		int dest = 0;
		int dec = 0;
		int sbkipower = 1;

		// from src to decimal
		while (src != 0) {
			int rem = src % 10;
			int quo = src / 10;

			dec += rem * sbkipower;
			sbkipower *= sb;

			src = quo;
		}

		int deckipower = 1;

		// from decimal to destination
		while (dec != 0) {
			int rem = dec % db;
			int quo = dec / db;

			dest += rem * deckipower;
			deckipower *= 10;

			dec = quo;
		}

		System.out.println(dest);
	}

}
