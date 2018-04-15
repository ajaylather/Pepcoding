package apr8_Hashmap_Application;

import java.util.ArrayList;
import java.util.HashMap;

public class Hashmap_Use {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// highestFrequencyCharacter("ajaylather");
		int[] one = { 5, 1, 2, 2, 4, 2, 1 };
		int[] two = { 1, 2, 5, 3, 1, 2, 1 };
		int[] one1 = { 5, 1, 2, 2, 6, 2, 1 };
		int[] two2 = { 1, 2, 5, 3, 1, 2, 1 };
		int[] arr= {2,12,9,16,10,5,3,20,25,11,1,8,6};
		longestIncSequence(arr);
//		gce1(one, two);
//		System.out.println();
//		gce2(one1, two2);

	}

	public static void highestFrequencyCharacter(String str) {
		HashMap<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}
		ArrayList<Character> keySet = new ArrayList<>(charMap.keySet());
		Integer max = Integer.MIN_VALUE;
		Character maxch = null;

		for (Character ch : keySet) {
			int chfr = charMap.get(ch);
			if (chfr > max) {
				max = chfr;
				maxch = ch;
			}
		}
		System.out.println(maxch);
	}

	public static void gce1(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : one) {
			map.put(i, 1);
		}
		for (int j : two) {
			if (map.containsKey(j)) {
				System.out.print(j + " ");
				map.remove(j);
			}
		}
	}

	public static void gce2(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : one) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		for (int j : two) {
			if ((map.containsKey(j))&&(map.get(j) > 0)) {
				System.out.print(j + " ");
				map.put(j, map.get(j) - 1);
			}
		}
	}
	
	public static void longestIncSequence(int[] arr) {
		HashMap<Integer, Boolean> hm=new HashMap<>();
		for(int val:arr) {
			hm.put(val, true);
		}
		
		for(int val:arr) {
			int vm1=val-1;
			int vp1=val+1;
			if(hm.containsKey(vm1)) {
				hm.put(val, false);
			}
			if(hm.containsKey(vp1)) {
				hm.put(vp1, false);
			}
		}
		
		ArrayList<Integer> omax=new ArrayList<>();
		for(int val:arr) {
			ArrayList<Integer> currmax=new ArrayList<>();
			if(hm.get(val)==true) {
				while(hm.containsKey(val)) {
					currmax.add(val);
					val++;
				}
			}
			if(currmax.size()>omax.size()) {
				omax=currmax;
			}
		}
		System.out.println(omax);
	}
	
	
}
