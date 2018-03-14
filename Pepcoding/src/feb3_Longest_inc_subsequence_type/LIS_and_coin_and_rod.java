package feb3_Longest_inc_subsequence_type;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS_and_coin_and_rod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int[] cost = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		int[] currency= {2,3,5,6};
		// lis(arr);
		//rodCutting(cost);
		coinChange(currency, 10);
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
	public static void coinChange(int[] currency,int amount) {
		int[] strg=new int[amount+1];
		ArrayList<ArrayList<Integer>>[] pstrg =new ArrayList[amount+1];
		strg[0]=1;
		for(int i=0;i<strg.length;i++) {
			pstrg[i]= new ArrayList<ArrayList<Integer>>();
			if(i==0) {
				pstrg[i].add(new ArrayList<Integer>());
			}
		}
		for(int cc:currency) {
			for(int i=cc;i<strg.length;i++) {
				strg[i]=strg[i]+strg[i-cc];
				for(int j=0;j<pstrg[i-cc].size();j++) {
					ArrayList<Integer> newAl=new ArrayList<Integer>(pstrg[i-cc].get(j));
					newAl.add(cc);
					pstrg[i].add(newAl);
				}
			}
		}
		System.out.println(strg[strg.length-1]);
		for(int i=0;i<pstrg[amount].size();i++) {
			System.out.println(pstrg[amount].get(i));
		}
	}
}
