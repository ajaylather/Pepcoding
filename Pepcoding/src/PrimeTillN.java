import java.io.*;
import java.util.*;

public class PrimeTillN {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int numtoc = 2;
		while (numtoc <= n) {
			boolean istnprime = true;
			int div = 2;

			while (div * div <= numtoc) {
				if (numtoc % div == 0) {
					istnprime = false;
					break;
				}

				div++;
			}

			if (istnprime == true) {
				System.out.print(numtoc + " ");
			}

			numtoc++;
		}
	}
}
