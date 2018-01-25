package assignments;

import java.util.Scanner;

public class Recursion_2_NthTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(ntr(n));
	}
	public static int ntr(int n) {
		if(n==1) {
			return 1;
		}
		int nth= n + ntr(n-1);
		return nth;
	}
}
