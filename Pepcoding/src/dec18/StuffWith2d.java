package dec18;

import java.util.Scanner;

public class StuffWith2d {

	public static void main(String[] args) {
		// int[][] arr = takeInput();
		// display(arr);

		// int[][] one = {
		// {10, 0, 20, 0},
		// {0, 30, 0, 40}
		// };
		// int[][] two = {
		// {1, 1, 1, 1},
		// {0, 1, 0, 1},
		// {1, 1, 0, 0},
		// {1, 1, 1, 0}
		// };
		// int[][] product = multiply(one, two);
		// if(product == null){
		// System.out.println("Not possible");
		// } else {
		// display(product);
		// }

		// int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33,
		// 34 }, { 41, 42, 43, 44 } };
		// spiralDisplay(arr);

		int[][] maze = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		exitPoint(maze);
	}

	public static int[][] takeInput() {
		int[][] retVal = null;

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = scn.nextInt();

		retVal = new int[rows][];
		for (int row = 0; row < retVal.length; row++) {
			System.out.println("Enter the number of columns for " + row + "th row");
			int cols = scn.nextInt();

			retVal[row] = new int[cols];
			for (int col = 0; col < retVal[row].length; col++) {
				System.out.println("Enter the value of [" + row + ", " + col + "] cell");
				retVal[row][col] = scn.nextInt();
			}
		}

		return retVal;
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] multiply(int[][] one, int[][] two) {
		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;

		if (c1 != r2) {
			return null;
		} else {
			int[][] retVal = new int[r1][c2];
			int cd = c1;

			for (int row = 0; row < retVal.length; row++) {
				for (int col = 0; col < retVal[row].length; col++) {
					for (int i = 0; i < cd; i++) {
						retVal[row][col] += one[row][i] * two[i][col];
					}
				}
			}

			return retVal;
		}
	}

	public static void waveDisplay(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.println(arr[row][col]);
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.println(arr[row][col]);
				}
			}
		}
	}

	public static void spiralDisplay(int[][] arr) {
		int rowMin = 0, rowMax = arr.length - 1;
		int colMin = 0, colMax = arr[0].length - 1;

		int counter = 1;
		int tne = arr.length * arr[0].length;
		while (counter <= tne) {
			// east wall
			for (int row = rowMin; row <= rowMax && counter <= tne; row++) {
				System.out.println(arr[row][colMin]);
				counter++;
			}
			colMin++;

			// south wall
			for (int col = colMin; col <= colMax && counter <= tne; col++) {
				System.out.println(arr[rowMax][col]);
				counter++;
			}
			rowMax--;

			// west wall
			for (int row = rowMax; row >= rowMin && counter <= tne; row--) {
				System.out.println(arr[row][colMax]);
				counter++;
			}
			colMax--;

			// north wall
			for (int col = colMax; col >= colMin && counter <= tne; col--) {
				System.out.println(arr[rowMin][col]);
				counter++;
			}
			rowMin++;
		}
	}

	public static void exitPoint(int[][] arr) {
		int dir = 0; // 0 - east, 1 - south, 2 - west, 3 - north
		int row = 0, col = 0;
		while (true) {
			dir += arr[row][col];
			dir %= 4;

			if (dir == 0) {// east
				col++;
				if (col == arr[0].length) {
					System.out.println(row + ", " + (arr[0].length - 1));
					break;
				}
			} else if (dir == 1) { // south
				row++;
				if (row == arr.length) {
					System.out.println((arr.length - 1) + ", " + col);
					break;
				}
			} else if (dir == 2) { // west
				col--;
				if (col == -1) {
					System.out.println(row + ", " + (0));
					break;
				}
			} else { // north
				row--;
				if (row == -1) {
					System.out.println(0 + ", " + col);
					break;
				}
			}
		}
	}
}
