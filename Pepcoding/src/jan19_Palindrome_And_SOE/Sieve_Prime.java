package jan19_Palindrome_And_SOE;

import java.util.Arrays;

public class Sieve_Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSOE(7507);
	}

	public static void printSOE(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for(int j=i;j*i<=n;j++) {
					primes[j*i]=false;
				}
			}
		}
		for (int i = 0; i <= primes.length - 1; i++) {
			if (primes[i] == true) {
				System.out.println(i);
			}
		}
	}
}
