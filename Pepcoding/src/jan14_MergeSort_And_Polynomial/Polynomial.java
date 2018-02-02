package jan14_MergeSort_And_Polynomial;

public class Polynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(poly(2, 8));
	}
	public static int poly(int x,int n) {
		int sum=0;
		int coeff=n;
		int pox=x;
		for(int i=0;i<n;i++) {
		sum=sum+pox*coeff;
		coeff--;
		pox*=x;
		}
		return sum;
	}
}
