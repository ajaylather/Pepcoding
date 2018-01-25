package jan14;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  arr1= {10,15,30,45,55,25,75};
		int[]  arr2= {16,18,32,35,40};
		int[] arr= {2,6,56,556,6656,56,54,6564,46,4,65,4};
		//int[] merged= mergeTwoSortedArrays(arr1, arr2);
		int[] sorted=mergeSort(arr, 0, arr.length-1);
		display(sorted);
		
	}
	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				result[k] = arr1[i];
				i++;
				k++;
			} else {
				result[k] = arr2[j];
				j++;
				k++;

			}
		}
		while (i < arr1.length) {
			result[k] = arr1[i];
			i++;
			k++;
		}
		while (j < arr2.length) {
			result[k] = arr2[j];
			j++;
			k++;
		}
		return result;
	}

	public static void display(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length-1; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.print(arr[arr.length-1]);
		System.out.println("]");
	}
	public static int[] mergeSort(int[] arr,int sidx,int lidx) {
		if(sidx==lidx) {
			int[] ba=new int[1];
			ba[0]=arr[sidx];
			return ba;
		}
		int mid=(sidx+lidx)/2;
		int[] fhalf=mergeSort(arr, sidx, mid);
		int[] shalf=mergeSort(arr, mid+1, lidx);
		int[] sorted=mergeTwoSortedArrays(fhalf, shalf);
		return sorted;
	}
}
