package apr25_Segment_And_Fenwick_Trees;

public class FenwickTree {
	int[] farr;
	
	public FenwickTree(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			update(i,arr[i]);
		}
	}
	
	public void update(int idx,int delta) {
		idx+=1;
		while(idx<farr.length-1) {
			idx+=getLastSetBit(idx);
			farr[idx]+=delta;
		}
	}
	
	public int getSum(int i,int j) {
		int getsumtillj=getPrefixSum(j);
		int getsumtilli=getPrefixSum(i-1);
		return getsumtillj-getsumtilli;
	}
	
	private int getPrefixSum(int idx) {
		idx+=1;
		int sum=0;
		while(idx!=0) {
			idx-=getLastSetBit(idx);
			sum+=farr[idx];
		}
		return sum;
	}
	
	private int getLastSetBit(int a) {
		return a &-a;
	}
}
