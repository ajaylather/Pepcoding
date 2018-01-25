package jan13;

public class knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wts = { 20, 30, 50, 10, 5 };
		int[] costs = { 10, 20, 2, 15, 100 };
		int capacity = 50;
		//System.out.println(knapsack1(wts, costs, capacity, 0, 0));
		knapsack2(wts, costs, capacity, 0, 0);
		System.out.println(maxsf);
	}

	public static int knapsack1(int[] wts, int[] costs, int capacity, int maxsofar, int vidx) {
		if (vidx == wts.length && capacity >= 0) {
			return maxsofar;
		}
		if (capacity < 0) {
			return 0;
		}
		int slwt = wts[vidx];
		int slwtcost = costs[vidx];
		int max1 = knapsack1(wts, costs, capacity - slwt, maxsofar + slwtcost, vidx + 1);
		int max2 = knapsack1(wts, costs, capacity, maxsofar, vidx + 1);
		return Math.max(max1, max2);
	}
	public static int maxsf=0;
	public static void knapsack2(int[] wts, int[] costs, int capacity, int maxsofar,int vidx) {
		if(vidx==wts.length) {
			if(maxsofar>maxsf) {
				maxsf=maxsofar;
			}
			return;
		}
		int slwt = wts[vidx]; 
		int slwtcost = costs[vidx];
		if(slwt<=capacity) {
			knapsack2(wts, costs, capacity - slwt, maxsofar + slwtcost, vidx + 1);
		}
		knapsack2(wts, costs, capacity, maxsofar, vidx + 1);
	}
}
