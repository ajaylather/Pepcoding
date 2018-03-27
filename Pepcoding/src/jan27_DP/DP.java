package jan27_DP;

import java.util.Arrays;

import assignments.TimeTaken;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeTaken.startAlgo();
		int[][] cost = { { 2, 1, 3, 4 }, { 2, 4, 2, 0 }, { 0, 1, 2, 6 }, { 5, 40, 3, 2 } };
		 int[] strg = new int[52];
//		 System.out.println(FibRI(47,strg));
//		 System.out.println(FIbItr(43));
//		 System.out.println(FibSlider(43));
//		 System.out.println(CBPItr(10));
//		 System.out.println(CBPSlider(10));
//		 System.out.println(CMP(3, 3));
//		 System.out.println(CMPSlider(3, 3));
//		 System.out.println(CMPDItr(3, 3));
//		 System.out.println(CMPDItrSir(3, 3));
//		 System.out.println(CMPDSlider(3, 3));
//		 System.out.println(MPMinCostPath(cost, 3, 3));
//		 System.out.println(MPMinCostSir(cost));
//		 System.out.println(TimeTaken.endAlgo());
	}

	public static int FibRI(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (strg[n] != 0) {
			return strg[n];
		}
		int fibn1 = FibRI(n - 1, strg);
		int fibn2 = FibRI(n - 2, strg);
		int fibn = fibn1 + fibn2;
		strg[n] = fibn;
		return fibn;
	}

	public static int FIbItr(int n) {
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}
		return strg[n];
	}

	public static int FibSlider(int n) {
		int[] slide = new int[2];
		slide[1] = 1;
		for (int i = 1; i < n; i++) {
			int newfib = slide[0] + slide[1];
			slide[0] = slide[1];
			slide[1] = newfib;
		}
		return slide[1];
	}

	public static int CBPItr(int end) {
		int[] res = new int[end + 6];
		res[end] = 1;
		for (int i = end - 1; i >= 0; i--) {
			for (int j = 1; j <= 6; j++) {
				res[i] += res[i + j];
			}
		}
		return res[0];
	}

	public static int CBPSlider(int end) {
		int[] sli = new int[6];
		sli[0] = 1;
		for (int slide = 0; slide < end; slide++) {
			int newval = sli[0] + sli[1] + sli[2] + sli[3] + sli[4] + sli[5];
			for (int j = 5; j > 0; j--) {
				sli[j] = sli[j - 1];
			}
			sli[0] = newval;
		}
		return sli[0];
	}

	public static int CMP(int dr, int dc) {
		int[][] res = new int[dr + 2][dc + 2];
		res[dr][dc] = 1;
		for (int cr = dr; cr >= 0; cr--) {
			for (int cc = dc; cc >= 0; cc--) {
				if (!(cc == dc && cr == dr)) {
					res[cr][cc] = res[cr + 1][cc] + res[cr][cc + 1];
				}
			}
		}
		return res[0][0];
	}

	public static int CMPSlider(int dr, int dc) {
		int[] slider = new int[dc + 1];
		Arrays.fill(slider, 1);
		for (int rslider = 1; rslider <= dr; rslider++) {
			for (int col = dc - 1; col >= 0; col--) {
				int newval = slider[col] + slider[col + 1];
				slider[col] = newval;
			}
		}
		return slider[0];
	}

	public static int CMPDItr(int dr, int dc) {
		int[][] res = new int[dr + 2][dc + 2];
		res[dr][dc] = 1;
		for (int cr = dr; cr >= 0; cr--) {
			for (int cc = dc; cc >= 0; cc--) {
				if (!(cc == dc && cr == dr)) {
					res[cr][cc] = res[cr + 1][cc] + res[cr][cc + 1] + res[cr + 1][cc + 1];
				}
			}
		}
		return res[0][0];
	}

	public static int CMPDItrSir(int dr, int dc) {
		int[][] res = new int[dr + 1][dc + 1];
		res[dr][dc] = 1;
		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				if (row + 1 <= dr && col + 1 <= dc) {
					res[row][col] += res[row + 1][col + 1];
				}
				if (row + 1 <= dr) {
					res[row][col] += res[row + 1][col];
				}
				if (col + 1 <= dc) {
					res[row][col] += res[row][col + 1];
				}
			}
		}
		return res[0][0];
	}

	public static int CMPDSlider(int dr, int dc) {
		int[] slider = new int[dc + 1];
		Arrays.fill(slider, 1);
		int diag = 1;
		for (int rslider = 1; rslider <= dr; rslider++) {
			for (int col = dc - 1; col >= 0; col--) {
				int newval = slider[col] + slider[col + 1] + diag;
				diag = slider[col];
				slider[col] = newval;
			}
			diag = 1;
		}
		return slider[0];
	}

	public static int MPMinCost(int[][] cost, int dr, int dc) {
		int mincost = 0;
		for (int cr = dr; cr >= 0; cr--) {
			for (int cc = dc; cc >= 0; cc--) {
				if (!(cc == dc && cr == dr)) {
					int currcost = Math.min(cost[cr + 1][cc + 1], Math.min(cost[cr][cc + 1], cost[cr + 1][cc]));
					mincost = mincost + currcost;
				}
			}
		}
		return mincost;
	}

	public static int MPMinCostSir(int[][] cost) {
		int dr = cost.length - 1;
		int dc = cost[0].length - 1;

		int[][] strg = new int[dr + 1][dc + 1];
		String[][] pstrg = new String[dr + 1][dc + 1];
		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				int rp1 = row + 1;
				int cp1 = col + 1;

				if (rp1 < strg.length && cp1 < strg.length) {
					if (strg[rp1][cp1] <= strg[rp1][col] && strg[rp1][cp1] <= strg[row][cp1]) {
						strg[row][col] = cost[row][col] + strg[rp1][cp1];
						pstrg[row][col] = "D" + pstrg[rp1][cp1];
					} else if (strg[row][cp1] <= strg[rp1][cp1] && strg[row][cp1] <= strg[rp1][col]) {
						strg[row][col] = cost[row][col] + strg[row][cp1];
						pstrg[row][col] = "H" + pstrg[row][cp1];
					} else {
						strg[row][col] = cost[row][col] + strg[rp1][col];
						pstrg[row][col] = "V" + pstrg[rp1][col];
					}
				} else if (rp1 < strg.length) {
					strg[row][col] = cost[row][col] + strg[rp1][col];
					pstrg[row][col] = "V" + pstrg[rp1][col];
				} else if (cp1 < strg.length) {
					strg[row][col] = cost[row][col] + strg[row][cp1];
					pstrg[row][col] = "H" + pstrg[row][cp1];
				} else {
					strg[row][col] = cost[dr][dc];
					pstrg[row][col] = "";
				}
			}
		}
		System.out.println(pstrg[0][0]);
		return strg[0][0];
	}

	public static String MPMinCostPath(int[][] cost) {
		int dr = cost.length - 1;
		int dc = cost[0].length - 1;
		int[][] strg = new int[dr + 1][dc + 1];
		String[][] path = new String[dr + 1][dc + 1];
		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				if (row + 1 <= dr && col + 1 <= dc) {
					if ((cost[row + 1][col] > cost[row][col + 1]) && (cost[row + 1][col] > cost[row + 1][col + 1])) {
						strg[row][col] += cost[row + 1][col];
					} else if ((cost[row][col + 1] > cost[row + 1][col])
							&& (cost[row + 1][col] > cost[row + 1][col + 1])) {
						strg[row][col] += cost[row][col + 1];

					} else {
						strg[row][col] += cost[row + 1][col + 1];
					}
				} else if (row + 1 <= dr) {
					strg[row][col] += cost[row + 1][col];

				} else if (col + 1 <= dc) {
					strg[row][col] += cost[row][col + 1];

				} else {
					strg[dr][dc] = cost[dr][dc];
				}
			}
		}
		return path[0][0];
	}
}
