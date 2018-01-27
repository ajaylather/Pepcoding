package jan27;

import assignments.TimeTaken;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeTaken.startAlgo();
		int[] strg=new int[52];
		//System.out.println(FibRI(47,strg));
		//System.out.println(FIbItr(43));
		//System.out.println(FibSlider(43));
		//System.out.println(CBPItr(10));
		//System.out.println(CBPSlider(10));
		System.out.println(CMP(2, 2));
		System.out.println(TimeTaken.endAlgo());
	}
	public static int FibRI(int n,int[] strg) {
		if(n==0||n==1) {
			return n;
		}
		if(strg[n]!=0) {
			return strg[n];
		}
		int fibn1=FibRI(n-1, strg);
		int fibn2=FibRI(n-2, strg);
		int fibn=fibn1+fibn2;
		strg[n]=fibn;
		return fibn;
	}
	public static int FIbItr(int n) {
		int [] strg=new int[n+1];
		strg[0]=0;
		strg[1]=1;
		for(int i=2;i<=n;i++) {
			strg[i]=strg[i-1]+strg[i-2];
		}
		return strg[n];
	}
	public static int FibSlider(int n) {
		int [] slide=new int[2];
		slide[1]=1;
		for(int i=1;i<n;i++) {
			int newfib=slide[0]+slide[1];
			slide[0]=slide[1];
			slide[1]=newfib;
		}
		return slide[1];
	}
	public static int CBPItr(int end) {
		int[] res=new int[end+6];
		res[end]=1;
		for(int i=end-1;i>=0;i--) {
			for(int j=1;j<=6;j++) {
				res[i]+=res[i+j];
			}
		}
		return res[0];
	}
	public static int CBPSlider(int end) {
		int[] sli=new int[6];
		sli[0]=1;
		for(int slide=0;slide<end;slide++) {
		int newval=sli[0]+sli[1]+sli[2]+sli[3]+sli[4]+sli[5];
			for(int j=5;j>0;j--) {
				sli[j]=sli[j-1];
			}
			sli[0]=newval;
		}
		return sli[0];
	}
	public static int CMP(int dr,int dc) {
		int[][] res=new int[dr+2][dc+2];
		res[dr][dc]=1;
		for(int cr=dr;cr>=0;cr--) {
			for(int cc=dc;cc>=0;cc--) {
				if(!(cc==dc&&cr==dr)) {
					res[cr][cc]=res[cr+1][cc]+res[cr][cc+1];
				}
			}
		}
		return res[0][0];
	}
	public static int CMPSlider(int dr,int dc) {
		
	}
}
