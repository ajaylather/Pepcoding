package feb11_largest_1_matrix;

public class largest_1_mat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, {0, 1, 1, 1, 0}, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };
		lom(arr);
	}

	public static void lom(int[][] arr) {
		int row = arr.length - 1;
		int col = arr[0].length - 1;
		int[][] board = new int[arr.length][arr[0].length];
		for (int i = row; i >= 0; i--) {
			for (int j = col; j >= 0; j--) {
				int rpl = i + 1;
				int cpl = j + 1;
				if (arr[i][j] != 0) {
					if (rpl < arr.length && cpl < arr[0].length) {
						board[i][j] = 1 + Math.min(board[rpl][cpl], Math.min(board[i][cpl], board[rpl][j]));
					} else  {
						board[i][j] = 1;
					}
				}
			}
			
		}
		
		for (int k = 0; k < board.length; k++) {
			for (int l = 0; l < board[0].length; l++) {
				System.out.print(board[k][l] + " ");
			}
			System.out.println();
		}
	}
}
