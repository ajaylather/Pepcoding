package jan13;

import java.util.Scanner;

public class Lexicograhical_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		printLexico(num, 0);
	}
	public static void printLexico(int end, int current) {
		if (current > end) {
			return;
		}
		if (current == 0) {
			System.out.println(current);
			current++;
		}
		for (int i = 0; i <= 10; i++) {
			if (current <= end) {
				System.out.println(current);
				current = current * 10;
				printLexico(end, current);
				current = current / 10;
				current++;
				if (current % 10 == 0)
					return;
			}
		}
	}
}
