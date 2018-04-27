package apr15_Priority_Queue_and_Huffman_Compresseion;

import java.util.PriorityQueue;

public class PQUse {

	public static void main(String[] args) {
		int[] arr = { 99, 56, 87, 32, 95 };
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int val : arr) {
			pq.add(val);
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
		car[] cars = new car[5];
		
	}

	public static class car implements Comparable<car> {
		String name;
		int speed;
		int price;

		car(String name, int speed, int price) {
			this.name = name;

			this.speed = speed;
			this.price = price;
		}

		@Override
		public int compareTo(car o) {
			// TODO Auto-generated method stub
			if (this.speed == o.speed) {
				return this.price - o.price;
			}
			return this.speed - o.speed;
		}
	}
}
