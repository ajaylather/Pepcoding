package apr22_Median_Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median_PQ {
	private PriorityQueue<Integer> leMinPQ = new PriorityQueue<>();
	// leMax is minimum priority queue of largest elements's half
	private PriorityQueue<Integer> seMaxPQ = new PriorityQueue<>(Collections.reverseOrder());
	// seMax is maximum priority queue of smallest elements's half
	private int size;

	public void add(int num) {
		if (seMaxPQ.size() > 0 && num < seMaxPQ.peek()) {
			seMaxPQ.add(num);
		} else if (leMinPQ.size() > 0 && num > leMinPQ.peek()) {
			leMinPQ.add(num);
		} else {
			seMaxPQ.add(num);
		}
		this.size++;
		if (seMaxPQ.size() - leMinPQ.size() == 2) {
			leMinPQ.add(seMaxPQ.remove());
		} else if (leMinPQ.size() - seMaxPQ.size() == 2) {
			seMaxPQ.add(leMinPQ.remove());
		}
	}

	public int peek() {
		if (this.size == 0) {
			return -1;
		}
		if (leMinPQ.size() > seMaxPQ.size()) {
			return leMinPQ.peek();
		} else {
			return seMaxPQ.peek();
		}
	}

	public int remove() {
		if (this.size == 0) {
			return -1;
		}
		this.size--;
		if (leMinPQ.size() > seMaxPQ.size()) {
			return leMinPQ.remove();
		} else {
			return seMaxPQ.remove();
		}
	}
}
