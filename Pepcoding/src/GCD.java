import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the first number: ");
		int n1 = scn.nextInt();

		System.out.println("Enter the second number: ");
		int n2 = scn.nextInt();

		while (n1 % n2 != 0) {
			int rem = n1 % n2;
			n1 = n2;
			n2 = rem;
		}

		System.out.println(n2);
	}

}
