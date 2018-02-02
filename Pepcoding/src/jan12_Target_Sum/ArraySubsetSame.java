package jan12_Target_Sum;

public class ArraySubsetSame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		// printSameSumSubsets(arr, 0,60, 0, 0, "", "");
		printTargetSumSubsets(arr, 0, 70, 0, "");
	}

	public static void printSameSumSubsets(int[] arr, int vidx, int sumst1, int sumst2, String sbst1, String sbst2) {
		if (sumst1 == sumst2 && vidx == arr.length) {
			System.out.println(sbst1 + " : " + sbst2);
		}
		if (vidx == arr.length) {
			return;
		}
		int st = arr[vidx];
		printSameSumSubsets(arr, vidx + 1, sumst1 + st, sumst2, sbst1 + st + ",", sbst2);
		printSameSumSubsets(arr, vidx + 1, sumst1, sumst2 + st, sbst1, sbst2 + st + ",");
	}

	public static void printTargetSumSubsets(int[] arr, int vidx, int target, int sumst2,
			String sbst2) {
		if ((sumst2 == target) && vidx == arr.length) {
			System.out.println(sbst2);
		}
		if (vidx == arr.length) {
			return;
		}
		int st = arr[vidx];
		printTargetSumSubsets(arr, vidx + 1, target, sumst2+st, sbst2 + st + ",");
		printTargetSumSubsets(arr, vidx + 1, target, sumst2, sbst2);
	}
}
