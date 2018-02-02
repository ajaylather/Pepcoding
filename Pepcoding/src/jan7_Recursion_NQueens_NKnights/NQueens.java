package jan7_Recursion_NQueens_NKnights;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[4][4];
		//printNQueens(board, 0, 0, "");
		printNQueensSmart(board, 0, 0,"");
		System.out.println(countsm);
	}

	static int count = 0;
	static int countsm = 0;

	public static void printNQueens(boolean[][] board, int boxNum, int qpsf, String csf) {
		if (qpsf == board.length) {
			if (IsTheBoardValid(board)) {
				System.out.println(csf);
			}
			count++;
			return;
		}
		for (int box = boxNum; box < board.length * board.length; box++) {
			int row = box / board.length;
			int col = box % board.length;
			board[row][col] = true;
			printNQueens(board, box + 1, qpsf + 1, csf + "["+row+","+ col+"]");
			board[row][col] = false;
		}
	}

	public static boolean IsTheQueenValid(boolean[][] board, int row, int col) {
		for (int cc = 0; cc < board.length; cc++) {
			if (board[row][cc] && cc != col) {
				return false;
			}
		}
		for (int rc = 0; rc < board.length; rc++) {
			if (board[rc][col] && rc != row) {
				return false;
			}
		}
		int k = 1;
		while (k < board.length) {
			int rmk = row - k;
			int cmk = col - k;
			int rpk = row + k;
			int cpk = col + k;
			if (rmk >= 0 && cmk >= 0 && board[rmk][cmk]) {
				return false;
			}
			if (rpk < board.length && cmk >= 0 && board[rpk][cmk]) {
				return false;
			}
			if (rmk >= 0 && cpk < board.length && board[rmk][cpk]) {
				return false;
			}
			if (rpk < board.length && cpk < board.length && board[rpk][cpk]) {
				return false;
			}
			k++;
		}
		return true;
	}

	public static boolean IsTheBoardValid(boolean[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == true && IsTheQueenValid(board, row, col) == false) {
					return false;
				}
			}
		}
		return true;
	}
	public static void printNQueensSmart(boolean[][] board,int boxNum,int row, String csf) {
		if(row==board.length) {
			System.out.println(csf);
			countsm++;
			return;
		}
		for(int col=0;col<board.length;col++) {
			if(IsTheQueenValid(board, row, col)) {
				board[row][col]=true;
				printNQueensSmart(board, boxNum, row+1, csf + "["+row+","+ col+"]");
				board[row][col]=false;
			}
		}
	}
}
