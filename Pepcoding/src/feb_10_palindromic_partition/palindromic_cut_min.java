package feb_10_palindromic_partition;

public class palindromic_cut_min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindromic_cutting("abbaa",0));
	}
//	public static int palindromic_cut_dp(String str,int si,int ei,int [][] strg) {
//		if(chkpal(str, 0)==true) {
//			return 0;
//		}
//		if(strg[si][ei]!=0) {
//			return strg[si][ei];
//		}
//		int mincost=Integer.MAX_VALUE;
//		for(int i=si;i<ei;i++) {
//			int cost1=palindromic_cut_dp(str,si,1,strg);
//			int cost2=palindromic_cut_dp(str,i,ei,strg);
//			int totcost=cost1+1+cost2;
//		}
//	}
	public static int palindromic_cutting(String str,int cmsf) {
		if(str.length()==1) {
			return 0;
		}
		if(chkpal(str, 0)==true) {
			return 0;
		}
		for(int i=1;i<str.length();i++) {
			cmsf+=1;
			int cost1=palindromic_cutting(str.substring(0,i),cmsf);
			int cost2=palindromic_cutting(str.substring(i),cmsf);
			int totcost=cost1+1+cost2;
			if(totcost<cmsf) {
				cmsf=totcost;
			}
		}
		return cmsf;
	}
	public static boolean chkpal(String str, int i) {
		if (i == str.length() / 2) {
			return true;
		}
		if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
			return false;
		}
		boolean chkpal = chkpal(str, i + 1);
		return chkpal;
	}
}
