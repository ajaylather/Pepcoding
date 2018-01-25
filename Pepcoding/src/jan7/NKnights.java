package jan7;

public class NKnights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[3][3];
		printNKnights(board, 0, 0, "");
		System.out.println(counter);
	}

	static int counter = 0;

	public static void printNKnights(boolean[][] board, int boxNum, int kpsf, String csf) {
		if (kpsf == board.length) {
			System.out.println(csf);
			counter++;
			return;
		}

		for (int box = boxNum; box < board.length * board.length; box++) {
			int row = box / board.length;
			int col = box % board.length;

			if (isTheKnightValid(board, row, col) == true) {
				board[row][col] = true;
				printNKnights(board, box + 1, kpsf + 1, csf + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}
		}

	}

	private static boolean isTheKnightValid(boolean[][] board, int row, int col) {
		int rm1 = row - 1;
		int rm2 = row - 2;
		int rp1 = row + 1;
		int rp2 = row + 2;
		int cm1 = col - 1;
		int cm2 = col - 2;
		int cp1 = col + 1;
		int cp2 = col + 2;

		if (isTheCellInBounds(board, rm2, cp1) && board[rm2][cp1] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rm1, cp2) && board[rm1][cp2] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rp1, cp2) && board[rp1][cp2] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rp2, cp1) && board[rp2][cp1] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rp2, cm1) && board[rp2][cm1] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rp1, cm2) && board[rp1][cm2] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rm1, cm2) && board[rm1][cm2] == true) {
			return false;
		}

		if (isTheCellInBounds(board, rm2, cm1) && board[rm2][cm1] == true) {
			return false;
		}

		return true;
	}

	private static boolean isTheCellInBounds(boolean[][] board, int row, int col) {
		if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
			return true;
		} else {
			return false;
		}
	}
}
