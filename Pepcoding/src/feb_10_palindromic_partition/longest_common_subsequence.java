package feb_10_palindromic_partition;

public class longest_common_subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="yafbcd";
		String s2="fzabad";
		lcs(s1,s2);
	}
	public static void lcs(String s1,String s2) {
		int[][] board= new int[s1.length()+1][s2.length()+1];
		for(int row=s2.length()-1;row>=0;row++) {
			for(int col=s1.length()-1;col>=0;col++) {
				if(s1.charAt(col)==s2.charAt(row)) {
					board[row][col]=board[row+1][col+1]+1;
				}else {
					board[row][col]=Math.max(board[row][col+1], board[row+1][col]);
				}
			}
		}
		display(board);
	}
	public static void display(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
