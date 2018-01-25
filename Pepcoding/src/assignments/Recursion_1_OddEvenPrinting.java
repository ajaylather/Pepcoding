package assignments;

import java.util.Scanner;

public class Recursion_1_OddEvenPrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		OddAndEvenNumberPrinting(n);
	}
	public static void OddAndEvenNumberPrinting(int n) {
		if(n==0) {
			return;
		}
		if(n%2!=0) {
			System.out.println(n);
		}
		OddAndEvenNumberPrinting(n-1);
		if(n%2==0) {
			System.out.println(n);
		}
	}
}
