import java.util.Scanner;

public class Fib {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number ");
		int num = scn.nextInt();

		int fn = 0;
		int sn = 1;

		int counter = 1;
		while (counter <= num) {
			int tn = fn + sn;
			fn = sn;
			sn = tn;
			counter++;
		}

		System.out.println(fn);
	}

}
