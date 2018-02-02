package jan19_Palindrome_And_SOE;

public class ReturnDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,6,3,5,4,2,5};
		//System.out.println(returnDuplicate(arr));
		System.out.println(returnDuplicatexor(arr));
		//display(arr);
	}
	public static int returnDuplicatexor(int[] arr) {
		int num=0;
		for(int i=0;i<arr.length;i++) {
			num=num^arr[i]^i;
		}
		return num;
	}
	public static int returnDuplicate(int[] arr) {
		int dupl=0;
		boolean[] arr1=new boolean[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(arr1[arr[i]]) {
				dupl=arr[i];
				break;
			}
			arr1[arr[i]]=true;
		}
		return dupl;
	}
	public static void display(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
