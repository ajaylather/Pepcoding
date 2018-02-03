package feb_3_Longest_inc_subsequence_type;

import java.util.Arrays;

public class LIS_and_coin_and_rod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int[] cost = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		// lis(arr);
		rodCutting(cost);
	}

	public static void lis(int[] arr) {
		int l = arr.length;
		int omax = 0;
		String omaxs = "";
		int[] strg = new int[l];
		String[] sstrg = new String[l];
		Arrays.fill(sstrg, "");
		strg[0] = 1;
		sstrg[0] = arr[0] + "";
		for (int i = 1; i < l; i++) {
			int max = 0;
			String smax = "";
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (strg[j] > max) {
						max = strg[j];
						smax = sstrg[j];
					}
				}
			}
			strg[i] = max + 1;
			sstrg[i] = smax + " " + arr[i];

			if (strg[i] > omax) {
				omax = strg[i];
				omaxs = sstrg[i];
			}
		}
		System.out.println(omax);
		System.out.println(omaxs);
	}

	public static void rodCutting(int[] arr) {
		int[] costs = new int[arr.length];
		String[] strg = new String[arr.length];
		for (int a = 0; a < arr.length; a++) {
			costs[a] = arr[a];
			strg[a] = a == 0 ? "" : a + "";
		}
		for (int i = 2; i < arr.length; i++) {
			for (int l = 0, r = i; l <= r; l++, r--) {
				if ((costs[l] + costs[r]) > costs[i]) {
					costs[i] = (costs[l] + costs[r]);
					strg[i] = "" + strg[l] + strg[r];
				}
			}
		}
		System.out.println(costs[arr.length - 1]);
		System.out.println(strg[arr.length - 1]);
	}

	public static void coin
}
