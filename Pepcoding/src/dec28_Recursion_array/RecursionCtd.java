package dec28_Recursion_array;

public class RecursionCtd {

	public static void main(String[] args) {
		 printTriangle(1, 1, 5);
		// printTriangleAnother(1, 1, 3);
		// System.out.println("hello");
		// printColumnsOfARow(1, 5);
	}

	public static void printColumnsOfARow(int col, int n) {
		if (col > n) {
			return;
		}

		System.out.print("*");
		printColumnsOfARow(col + 1, n);
	}

	public static void printTriangle(int row, int col, int n) {
		if (row > n) {
			return;
		}

		if (col > row) {
			System.out.println();
			printTriangle(row + 1, 1, n);
			return;
		}

		System.out.print("*");
		printTriangle(row, col + 1, n);
	}

	public static void printInvTriangle(int row, int col, int n) {
		if (row > n) {
			return;
		}

		if (col > row) {
			printInvTriangle(row + 1, 1, n);
			if(n>row) {
			System.out.println();}
			return;
		}

		printInvTriangle(row, col + 1, n);
		System.out.print("*");
	}

	public static void printTriangleAnother(int row, int col, int n) {
		if (row > n) {
			return;
		}

		if (col > row) {
			return;
		}

		System.out.print("*");
		printTriangleAnother(row, col + 1, n);

		if (col == row) {
			System.out.println();
			printTriangleAnother(row + 1, 1, n);
		}
	}
	public static int max(int[] arr, int vidx){
		if(vidx == arr.length){
			return Integer.MIN_VALUE;
		}
		
		int maxisa = max(arr, vidx + 1);
		int maxifa = 0;
		
		if(maxisa > arr[vidx]){
			maxifa = maxisa;
		} else {
			maxifa = arr[vidx];
		}
		
		return  maxifa;
	}
	
	public static boolean find(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return false;
		}
		
		if(arr[vidx] == data){
			return true;
		}
		
		boolean foundinsa = find(arr, vidx + 1, data);
		return foundinsa;
	}
	
	public static int firstIndex(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return -1;
		}
		
		if(arr[vidx] == data){
			return vidx;
		}
		
		int fiinsa = firstIndex(arr, vidx + 1, data);
		return fiinsa;
	}
	
	public static int lastIndex(int[] arr, int vidx, int data){
		if(vidx == arr.length){
			return -1;
		}
		
		int liinsa = lastIndex(arr, vidx + 1, data);
		if(liinsa != -1){
			 return liinsa;
		} else {
			if(arr[vidx] == data){
				return vidx;
			} else {
				return -1;
			}
		}
	}
	public static int[] allIndices(int[] arr, int vidx, int data, int fsf){
		if(vidx == arr.length){
			int[] ba = new int[fsf];
			return ba;
		}
		int[] result = allIndices(arr, vidx + 1, data, 
								  arr[vidx] == data? fsf + 1: fsf);
		if(arr[vidx] == data){
			result[fsf] = vidx;
		}
		
		return result;
	}
}
