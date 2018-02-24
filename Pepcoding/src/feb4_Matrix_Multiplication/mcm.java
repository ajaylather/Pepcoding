package feb4_Matrix_Multiplication;

import java.util.Arrays;

public class mcm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dims= {10,20,30,40,50,60};
		System.out.println(mat_multiplication(dims, 0, dims.length-1, new int[dims.length][dims.length]));
	}
	public static int mat_multiplication(int[] dims,int si,int ei,int[][] strg) {
		if(si==ei-1) {
			return 0;
		}
		if(strg[si][ei]!=0) {
			return strg[si][ei];
		}
		int mincost=Integer.MAX_VALUE;
		for(int i=si+1;i<ei;i++) {
			int cost1=mat_multiplication(dims,si,i,strg);
			int cost2=mat_multiplication(dims,i,ei,strg);
			int cost3=dims[si]*dims[i]*dims[ei];
			int totalcost=cost1+cost2+cost3;
			
			if(totalcost<mincost) {
				mincost=totalcost;
			}
		}
		strg[ei][si]=mincost;
		return mincost;
	}
}
