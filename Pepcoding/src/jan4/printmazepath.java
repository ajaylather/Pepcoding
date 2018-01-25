package jan4;

public class printmazepath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printmazepatmm(0, 0, 2, 2, "");
	}
	public static void printmazepat(int cr,int cc,int er,int ec,String psf) {
		if(cr>er) {
			return;
		}
		if(cc>ec) {
			return;
		}
		if(cr==er&cc==ec) {
			System.out.println(psf);
			return;
		}
		printmazepat(cr+1, cc, er, ec, psf+"H");
		printmazepat(cr, cc+1, er, ec, psf+"V");
		printmazepat(cr+1,cc+1,er,ec,psf+"D");
	}
	public static void printmazepatmm(int cr,int cc,int er,int ec,String psf) {
		if(cr>er) {
			return;
		}
		if(cc>ec) {
			return;
		}
		if(cr==er&&cc==ec) {
			System.out.println(psf);
			return;
		}
		for(int i=1;i<=ec;i++) {
			printmazepatmm(cr, cc+i, er, ec, psf+"H"+i+" ");
		}
		for(int i=1;i<=er;i++) {
			printmazepatmm(cr+i, cc, er, ec, psf+"V"+i+" ");
		}
		for(int i=1;i<=er&&i<=ec;i++) {
			printmazepatmm(cr+i,cc+i,er,ec,psf+"D"+i+" ");
		}
	}
}
