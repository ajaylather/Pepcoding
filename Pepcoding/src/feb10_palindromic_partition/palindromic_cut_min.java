package feb10_palindromic_partition;

public class palindromic_cut_min {

	public static void main(String[] args) {
		String str = "abbbbasdaaa";
		int[][] strg = new int[str.length()][str.length()];
		boolean[][] presults = new boolean[str.length()][str.length()];
		//
		for (int l = 1; l <= str.length(); l++) {
			int si = 0;
			int ei = si + l - 1;
			while (ei < str.length()) {
				// System.out.println(si + " " + ei);
				if (l == 1) {
					presults[si][ei] = true;
				} else if (l == 2) {
					presults[si][ei] = str.charAt(si) == str.charAt(ei);
				} else {
					if (str.charAt(si) == str.charAt(ei)) {
						presults[si][ei] = presults[si + 1][ei - 1];
					}
				}
				si++;
				ei++;
				counter++;
			}
		}

		System.out.println(palindromepartitions(str, 0, str.length() - 1, strg, presults));
		System.out.println(counter);
	}

	static int counter = 0;

	// minimum cuts to make each partition a palindrome
	public static int palindromepartitions(String str, int si, int ei, int[][] strg, boolean[][] presults) {
		// if(IsPalindrome(str, si, ei)){
		// return 0;
		// }
		if (presults[si][ei] == true) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int i = si; i < ei; i++) {
			int c1 = palindromepartitions(str, si, i, strg, presults);
			int c2 = palindromepartitions(str, i + 1, ei, strg, presults);
			int tc = c1 + c2 + 1;
			if (tc < min) {
				min = tc;
			}
			counter++;
		}

		strg[si][ei] = min;
		return min;
	}

	public static boolean IsPalindrome(String str, int si, int ei) {
		int left = si, right = ei;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
			counter++;
		}

		return true;
	}
}