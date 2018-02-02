package jan4_Recursion_Mazepath;

public class MazepathWithBombs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static boolean printMazepathWithBomb(int[][] arr,int row,int col,boolean[][] vstd) {
		
		if(row==arr.length&&col==arr.length) {
			return true;
		}
		int left=col-1;
		int right=col+1;
		int up=row+1;
		int down=row-1;
		if(vstd[row][col]=true) {
			boolean gup=printMazepathWithBomb(arr, up, col,vstd);
			boolean gdwn=printMazepathWithBomb(arr, down, col,vstd);
			boolean glft=printMazepathWithBomb(arr, row, left,vstd);
			boolean rht=printMazepathWithBomb(arr, row, right, vstd);	
		}
		return false;
	}
}
