package feb11_largest_1_matrix;

public class is_target_sum_subs_possible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,5};
		itsp(arr, 6);
	}
	public static void itsp(int[] arr,int target) {
		boolean[][] board=new boolean[arr.length+1][target+1];
		for(int i=0;i<board.length;i++) {
			board[i][0]=true;
		}
		for(int row=1;row<board.length;row++) {
			for(int col=1;col<board[0].length;col++) {
				boolean cno=board[row-1][col];
				boolean cyes=false;
				if(col-arr[row-1]>=0) {
					cyes=board[row-1][col-arr[row-1]];
				}
				board[row][col]=cyes||cno;
			}
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
