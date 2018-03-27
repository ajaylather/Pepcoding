package feb10_palindromic_partition;

public class longest_bitonic_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,11,2,10,4,5,2,1};
		lbs(arr);
	}
	public static void lbs(int[] arr) {
		int l = arr.length;
		int[] lis = new int[l];
		int[] lds = new int[l];
		lis[0] = 1;
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (lis[j] > lis[i]) {
						lis[i]=lis[j];
					}
				}
			}
			lis[i]+=1;
		}
		lds[arr.length-1]=1;
		for (int i = arr.length-2;i>0;i--) {
			for (int j = arr.length-1;j>i;j--) {
				if (arr[j] < arr[i]) {
					if (lds[j] > lds[i]) {
						lds[i] = lds[j];
					}
				}
			}
			lds[i]+=1;
		}
		int omaxlen=0;
		for(int i=0;i<arr.length;i++) {
			if(lis[i]+lds[i]>omaxlen) {
				omaxlen=lis[i]+lds[i]-1;
			}
		}
		System.out.println(omaxlen);
	}
}
