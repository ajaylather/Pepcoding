
public class LargestOfThree {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 5;

		/*
		 * if(a >= b && a >= c){ System.out.println(a); return; } if(b >= a && b >= c){
		 * System.out.println(b); return; } System.out.println(c);
		 */

		// if(a >= b && a >= c){
		// System.out.println(a);
		// } else {
		// if(b >= a && b >= c){
		// System.out.println(b);
		// } else {
		// System.out.println(c);
		// }
		// }

		if (a >= b && a >= c) {
			System.out.println(a);
		} else if (b >= a && b >= c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}

}
