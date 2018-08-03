package apr29;

import java.util.ArrayList;
import java.util.HashMap;

public class GenericHeap<T> {
	private ArrayList<T> data = new ArrayList<>();
	private HashMap<T, Integer> idxmap = new HashMap<>();
	private boolean rev = false;

	public GenericHeap() {

	}

	public GenericHeap(T[] arr, boolean rev) {
		this.rev = rev;
		for (T val : arr) {
			data.add(val);
			idxmap.put(val, data.size() - 1);
		}

		for (int i = data.size() / 2 - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public T peek() {
		return data.get(0);
	}

	public void add(T val) {
		data.add(val);
		idxmap.put(val, data.size() - 1);

		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		// smaller the value, higher the priority
		if (myCompareTo(ci, pi) < 0) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	public int myCompareTo(int i, int j) {
		Comparable<T> ith = (Comparable<T>) data.get(i);
		T jth = data.get(j);

		if (rev == false) {
			return ith.compareTo(jth);
		} else {
			return -1 * ith.compareTo(jth);
		}
	}
  
	public T remove() {
		swap(0, data.size() - 1);

		T rv = data.remove(data.size() - 1);
		idxmap.remove(rv);

		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int minidx = pi;

		if (lci < data.size() && myCompareTo(lci, minidx) < 0) {
			minidx = lci;
		}

		if (rci < data.size() && myCompareTo(rci, minidx) < 0) {
			minidx = rci;
		}

		if (minidx != pi) {
			swap(pi, minidx);
			downheapify(minidx);
		}
	}

	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);

		idxmap.put(ith, j);
		idxmap.put(jth, i);
	}

	public void erase(T val) {
		int validx = idxmap.get(val);
		swap(validx, data.size() - 1);

		data.remove(data.size() - 1);
		idxmap.remove(val);

		if (validx < data.size()) {
			downheapify(validx);
			upheapify(validx);
		}
	}

}
