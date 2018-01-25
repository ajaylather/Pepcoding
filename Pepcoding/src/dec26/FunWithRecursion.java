package dec26;

public class FunWithRecursion {

	public static void main(String[] args) {
		PDI(5);
		//System.out.println(Fib(4));
	}

	public static void printDecreasing(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		printDecreasing(n - 1);
	}

	public static void printIncreasing(int n) {
		if (n == 0) {
			return;
		}

		printIncreasing(n - 1);
		System.out.println(n);
	}

	public static void PDI(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static int Factorial(int n) {
		if (n == 0) {
			return 1;
		}

		int nm1kafact = Factorial(n - 1);
		int nkafact = nm1kafact * n;

		return nkafact;
	}

	public static int Power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xkipowernm1 = Power(x, n - 1);
		int xkipowern = xkipowernm1 * x;

		return xkipowern;
	}

	public static int PowerBtr(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xkipownb2 = PowerBtr(x, n / 2);
		int xkipown = 1;
		if (n % 2 == 0) {
			xkipown = xkipownb2 * xkipownb2;
		} else {
			xkipown = xkipownb2 * xkipownb2 * x;
		}

		return xkipown;
	}

	public static int Fib(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		System.out.println("Hi from " + n);

		int fibnm1 = Fib(n - 1);

		System.out.println("Hi to bye from " + n);

		int fibnm2 = Fib(n - 2);

		System.out.println("Bye from " + n);

		int fibn = fibnm1 + fibnm2;
		return fibn;
	}

	public static void Toh(String src, String dest, String helper, int ndisc) {
		if (ndisc == 0) {
			return;
		}

		Toh(src, helper, dest, ndisc - 1);
		System.out.println("Move " + ndisc + "vi from " + src + " to " + dest);
		Toh(helper, dest, src, ndisc - 1);
	}

}
