package assignments;

import java.util.Scanner;

public class Recursion_3_PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		PascalTriangle11(5);
		//PascalTriangle(1, 1, 5);
	}
	//This function uses powers of 11 approach
	public static void PascalTriangle11(int rows) {
		if(rows==0) {
			return;
		}
		PascalTriangle11(rows-1);
		System.out.println(power(11, rows-1));
	}
	public static int power(int x,int n) {
		if(n==0) {
			return 1;
		}
		int pwrb2=power(x,n/2);
		int pwr=1;
		if(n%2==0) {
			pwr=pwrb2*pwrb2;
		}else {
			pwr=pwrb2*pwrb2*x;
		}
		return pwr;
	}
	//This function uses factorial approach
	public static void PascalTriangle(int row,int col,int n) {
		if(row>n) {
			return;
		}
		if(col>row) {
			System.out.println();
			PascalTriangle(row+1, 1, n);
			return;
		}
		System.out.print(ncn(row-1, col-1));
		PascalTriangle(row, col+1, n);
	}
	public static int factorial(int n) {
		if(n==0) {
			return 1;
		}
		int fact1=n*factorial(n-1);
		return fact1;
	}
	public static int ncn(int a,int b) {
		int ncn=(factorial(a)/(factorial(b)*factorial(a-b)));
		return ncn;
	}
}
