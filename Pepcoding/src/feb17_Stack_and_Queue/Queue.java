package feb17_Stack_and_Queue;

public class Queue {
	int[] data;
	int size;
	int front;

	public Queue(int capacity) {
		this.data = new int[capacity];
		this.size = 0;
		this.front = 0;
	}

	public Queue() {
		this(5);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void enQueue(int value) {
		if (this.size == this.data.length) {
			System.out.println("Queue is full");
			return;
		}
		int tail = (front + size) % this.data.length;
		this.data[tail] = value;
		this.size++;
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return 0;
		}
		int delval = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return delval;
	}

	public int front() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return 0;
		}
		return this.data[front];
	}

	public void display() {
		for (int i = 0; i <this.size; i++) {
			int temp= (i + this.front) % this.data.length;
			System.out.print(this.data[temp] + "->");
		}
		System.out.println("End");
		System.out.println("----------------------------");
	}
}
