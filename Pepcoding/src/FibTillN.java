import java.util.Scanner;

public class FibTillN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number ");
		int num = scn.nextInt();

		int fn = 0;
		int sn = 1;

		while (fn <= num) {
			System.out.print(fn + " ");
			int tn = fn + sn;
			fn = sn;
			sn = tn;
		}
	}

}
