package apr15_Priority_Queue_and_Huffman_Compresseion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQLists_Sort {

	public static class mergePair implements Comparable<mergePair> {
		int lidx;
		int dindx;
		int data;

		public mergePair(int lidx, int didx, int data) {
			// TODO Auto-generated constructor stub
			this.lidx = lidx;
			this.dindx = didx;
			this.data = data;
		}

		@Override
		public int compareTo(mergePair o) {
			// TODO Auto-generated method stub
			return this.data - o.data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40, 51, 60)));
		lists.add(new ArrayList<>(Arrays.asList(11, 15, 17)));
		lists.add(new ArrayList<>(Arrays.asList(22, 27, 31, 35)));
		lists.add(new ArrayList<>(Arrays.asList(28, 29, 42, 44, 90)));
		// System.out.println(mergeKSortedLists(lists));
		// int[] arr= {55,568,465,7821,56,8,56,796,86,986,45};
		// System.out.println(kLargestElements(arr, 4));
		// System.out.println(kSmallestElements(arr, 4));
		int[] arr = { 21, 10, 30, 2, 27, 15, 88, 65, 45, 55 };
		almostSorted(arr, 3);
	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<mergePair> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.size(); i++) {
			mergePair m = new mergePair(i, 0, lists.get(i).get(0));
			pq.add(m);
		}
		while (!pq.isEmpty()) {
			mergePair removedPair = pq.remove();

			result.add(removedPair.data);

			int newdidx = removedPair.dindx + 1;

			if (newdidx < lists.get(removedPair.lidx).size()) {
				int newlidx = removedPair.lidx;
				int newdata = lists.get(newlidx).get(newdidx);
				mergePair newPair = new mergePair(newlidx, newdidx, newdata);
				pq.add(newPair);
			}
		}
		return result;
	}
	// In kth smallest elements we've reversed the comparator of the priority queue,
	// so instead of giving smallest element,it'll give the largest element

	public static ArrayList<Integer> kLargestElements(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k + 1; i < arr.length; i++) {
			int remdata = pq.remove();
			if (arr[i] > remdata) {
				pq.add(arr[i]);
			} else {
				pq.add(remdata);
			}
		}
		while (!pq.isEmpty()) {
			result.add(0, pq.remove());
		}
		return result;
	}

	public static ArrayList<Integer> kSmallestElements(int[] arr, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			int remdata = pq.remove();
			if (arr[i] < remdata) {
				pq.add(arr[i]);
			} else {
				pq.add(remdata);
			}
		}
		while (!pq.isEmpty()) {
			result.add(0, pq.remove());
		}
		return result;
	}

	public static void almostSorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}
		int putidx = 0;
		int getidx = k + 1;

		while (pq.size() > 0) {
			arr[putidx] = pq.remove();
			putidx++;

			if (getidx < arr.length) {
				pq.add(arr[getidx]);
				getidx++;
			}
		}
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
}
