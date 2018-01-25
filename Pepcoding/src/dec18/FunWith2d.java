package dec18;

public class FunWith2d {

	public static void main(String[] args) {
		int[][] arr;

		arr = new int[3][4];

		System.out.println(arr);
		System.out.println(arr.length); // row
		System.out.println(arr[0].length); // col

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		// display(arr);

		// jagged array
		arr = new int[3][];
		// arr = new int[][2];

		arr[0] = new int[2];
		arr[1] = new int[4];
		arr[2] = new int[3];
		display(arr);

		arr[1][3] = 100;
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

}
