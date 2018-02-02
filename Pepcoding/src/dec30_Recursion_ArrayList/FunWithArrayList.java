package dec30_Recursion_ArrayList;

import java.util.ArrayList;

public class FunWithArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(4);
		System.out.println("Contents = " + list + ". Size = " + list.size());
		
		// adding
		list.add(10);
		System.out.println("Contents = " + list + ". Size = " + list.size());
		
		list.add(20);
		System.out.println("Contents = " + list + ". Size = " + list.size());
		
		list.add(30);
		System.out.println("Contents = " + list + ". Size = " + list.size());
		
		list.add(40);
		System.out.println("Contents = " + list + ". Size = " + list.size());
	
		// get, set
		System.out.println(list.get(2));
		list.set(2, 300);
		System.out.println("Contents = " + list + ". Size = " + list.size());
		
		list.remove(2);
		System.out.println("Contents = " + list + ". Size = " + list.size());
	
		list.add(2, 3000);
		System.out.println("Contents = " + list + ". Size = " + list.size());
	
		int[] one = {1, 1, 2, 2, 2, 3, 5};
		int[] two = {1, 1, 1, 2, 2, 4, 5};
		ArrayList<Integer> result = gce(one, two);
		System.out.println(result);
	}
	
	public static ArrayList<Integer> gce(int[] one, int[] two){
		ArrayList<Integer> rv = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		while(i < one.length && j < two.length){
			if(one[i] < two[j]){
				i++;
			} else if(one[i] > two[j]){
				j++;
			} else {
				rv.add(one[i]);
				i++;
				j++;
			}
		}
		
		return rv;
	}
	
	
	
	
	
	
	

}