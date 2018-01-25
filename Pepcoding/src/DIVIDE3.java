import java.util.Scanner;

public class DIVIDE3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			long k = sc.nextLong();
			int d0 = sc.nextInt();
			int d1 = sc.nextInt();
			System.out.println(chck( k, d0,d1));
		}
	}

	public static String chck(long k, int d0,int d1) {
		if((d0+d1)%3==0) {
			return "YES";
		}else return "NO";
	}
}
