package jan21;

public class BoardPAthDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int cbp(int curr,int end) {
		int count=0;
		for(int dice=2;dice<=6;dice++) {
			if(curr+dice<=end) {
				int cdice=cbp(curr+dice,end);
				count=count+dice;
			}
		}
		return count;
	}
}
