import java.util.*;

public class SumtoN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the value of n: ");
		int n = scn.nextInt();
		int sum = 0;

		int counter = 1;
		while (counter <= n) {
			sum = sum + counter;
			counter = counter + 1;
		}

		System.out.println("sum = " + sum);
	}

}
