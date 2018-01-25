package assignments;

import java.util.Scanner;

public class Pep_Java_2NumberSystemAndFunctions_4Series {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int d = scn.nextInt();
		int r = scn.nextInt();
		int n = scn.nextInt();

		int fap = a;
		int fgp = a;
		int fagp = a;
		int sap = 0;
		int sgp = 0;
		int sagp = 0;

		int counter = 1;
		while (counter <= n) {
			sap += fap;
			sgp += fgp;
			sagp += fagp;

			if (counter < n) {
				fap += d;
				fgp *= r;
				fagp = fap * fgp / a;
			}

			counter++;
		}

		System.out.print(fap + " ");
		System.out.print(fgp + " ");
		System.out.print(fagp + " ");
		System.out.print(sap + " ");
		System.out.print(sgp + " ");
		System.out.print(sagp);
	}

}
