package apr30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Client {

	private static class Pair implements Comparable<Pair>{
		int value;
		int didx;
		int lidx;
		
		@Override
		public int compareTo(Pair o) {
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//		
//		lists.add(new ArrayList<>());
//		lists.add(new ArrayList<>());
//		lists.add(new ArrayList<>());
//		lists.add(new ArrayList<>());
//		
//		lists.get(0).addAll(Arrays.asList(10, 20, 30, 40));
//		lists.get(1).addAll(Arrays.asList(11, 15, 17));
//		lists.get(2).addAll(Arrays.asList(5, 7, 41, 45));
//		lists.get(3).addAll(Arrays.asList(2, 12, 18, 25, 32));
//		
//		System.out.println(mergeKSortedLists(lists));
		
//		int[] arr = {20, 22, 10, 25, 37, 50, 31, 59};
//		almostSorted(arr, 2);
		
//		LinkedList<String> list = new LinkedList<>();
//		list.addLast("Sumeet");
//		list.addLast("doesnt");
//		list.addLast("know");
//		list.addLast("what");
//
//		list.display();
		
		HashMap<String, Integer> pop = new HashMap<>();
		pop.put("India", 120);
		pop.put("China", 200);
		pop.put("Pak", 80);
		pop.put("US", 25);
		pop.put("UK", 20);
		pop.put("Nigeria", 50);
//		pop.display();
		
		pop.put("Utopia", 0);
//		pop.display();
		
		pop.put("India", 125);
		pop.display();
		
		System.out.println(pop.get("India"));
		System.out.println(pop.get("Random"));
		
		System.out.println(pop.remove("Pak"));
		System.out.println(pop.remove("Pak"));
//		pop.display();
		
//		System.out.println(pop.keyset());
		pop.put("Aus", 15);
		pop.put("Sweden", 12);
		pop.display();
		
		pop.put("Narnia", 10);
		pop.display();
		
		
	}

	// tc - nlogk, sc - k
	private static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		PriorityQueue<Pair> heap = new PriorityQueue<>();
		
		for(int i = 0; i < lists.size(); i++){
			Pair pair = new Pair();
			pair.didx = 0;
			pair.lidx = i;
			pair.value = lists.get(pair.lidx).get(pair.didx);
			heap.add(pair);
		}
		
		ArrayList<Integer> ret = new ArrayList<>();
		while(heap.size() > 0){
			Pair rp = heap.remove();
			ret.add(rp.value);
			
			rp.didx++;
			if(rp.didx < lists.get(rp.lidx).size()){
				rp.value = lists.get(rp.lidx).get(rp.didx);
				heap.add(rp);
			}
		}
		
		return ret;
	}

	private static void almostSorted(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int i = 0;
		for(i = 0; i <= k; i++){
			pq.add(arr[i]);
		}
		
		while(i < arr.length){
			System.out.println(pq.remove());
			pq.add(arr[i]);
			i++;
		}
		
		while(pq.size() > 0){
			System.out.println(pq.remove());
		}
	}
}
