package dec10;

public class Primes {

	public static void main(String[] args) {
		PrintPrimes(100);
	}

	public static void PrintPrimes(int n) {
		for (int numtoc = 2; numtoc <= n; numtoc++) {
			boolean isnumtocprime = IsPrime(numtoc);
			if (isnumtocprime == true) {
				System.out.println(numtoc);
			}
		}
	}

	public static boolean IsPrime(int num) {
		int div = 2;

		while (div * div <= num) {
			if (num % div == 0) {
				return false;
			}
			div++;
		}

		return true;
	}

}
