package apr29;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	private HashMap<Integer, Integer> idxmap = new HashMap<>();

	public Heap() {

	}

	public Heap(int[] arr) {
		for (int val : arr) {
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

	public int peek() {
		return data.get(0);
	}

	public void add(int val) {
		data.add(val);
		idxmap.put(val, data.size() - 1);

		upheapify(data.size() - 1);
	}

	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;

		// smaller the value, higher the priority
		if (data.get(ci) < data.get(pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	public int remove() {
		swap(0, data.size() - 1);

		int rv = data.remove(data.size() - 1);
		idxmap.remove(rv);

		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int minidx = pi;

		if (lci < data.size() && data.get(lci) < data.get(minidx)) {
			minidx = lci;
		}

		if (rci < data.size() && data.get(rci) < data.get(minidx)) {
			minidx = rci;
		}

		if (minidx != pi) {
			swap(pi, minidx);
			downheapify(minidx);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);

		idxmap.put(ith, j);
		idxmap.put(jth, i);
	}

	public void erase(int val) {
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
