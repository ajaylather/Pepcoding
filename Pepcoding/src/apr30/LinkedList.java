package apr30;

public class LinkedList<T> {
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// o1
	public int size() {
		return this.size;
	}

	// o1
	public boolean isEmpty() {
		return this.size == 0;
	}

	// on
	public void display() {
		for (Node temp = this.head; temp != null; temp = temp.next) {
			System.out.print(temp.data + "->");
		}
		System.out.println(".");
		System.out.println("----------------------------------------");
	}

	// o1
	public void addFirst(T value) {
		if (this.size == 0) {
			this.handleSize0Addition(value);
			return;
		}
		// create
		Node temp = new Node();

		// update
		temp.data = value;

		// connect
		temp.next = this.head;

		// summary
		this.head = temp;
		this.size++;
	}

	// o1
	public void addLast(T value) {
		if (this.size == 0) {
			this.handleSize0Addition(value);
			return;
		}
		// create
		Node temp = new Node();

		// update
		temp.data = value;
		temp.next = null;

		// connect
		this.tail.next = temp;

		// summary
		this.tail = temp;
		this.size++;
	}

	// o1
	private void handleSize0Addition(T value) {
		Node temp = new Node();
		temp.data = value;
		temp.next = null;

		this.head = temp;
		this.tail = temp;
		this.size++;
	}

	// on
	public void addAt(T value, int idx) {
		if (idx < 0 || idx > this.size) {
			System.out.println("Invalid index");
			return;
		} else if (idx == 0) {
			this.addFirst(value);
		} else if (idx == this.size) {
			this.addLast(value);
		} else {
			// create
			Node temp = new Node();

			// update
			temp.data = value;

			// connect
			Node im1 = this.getNodeAt(idx - 1);
			temp.next = im1.next;
			im1.next = temp;

			// summary
			this.size++;
		}
	}

	// o1
	public T getFirst() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return null;
		}

		return this.head.data;
	}

	// o1
	public T getLast() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return null;
		}

		return this.tail.data;
	}

	// on
	public T getAt(int idx) {
		if (idx < 0 || idx >= this.size) {
			System.out.println("Index out of bound");
			return null;
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	// on
	private Node getNodeAt(int idx) {
		if (idx < 0 || idx >= this.size) {
			System.out.println("Index out of bound");
			return null;
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// o1
	public T removeFirst() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (this.size == 1) {
			return this.handleSize1Removal();
		}

		// collect
		Node temp = this.head;

		// disconnect
		Node second = this.getNodeAt(1);
		temp.next = null;

		// summary
		this.head = second;
		this.size--;

		// return
		return temp.data;
	}

	// on
	public T removeLast() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (this.size == 1) {
			return this.handleSize1Removal();
		}

		// collect
		Node temp = this.tail;

		// disconnect
		Node secondLast = this.getNodeAt(this.size - 2);
		secondLast.next = null;

		// summary
		this.tail = secondLast;
		this.size--;

		// return
		return temp.data;
	}

	// on
	public T removeAt(int idx) {
		if (idx < 0 || idx >= this.size) {
			System.out.println("Index out of bound");
			return null;
		} else if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			// collect
			Node im1 = this.getNodeAt(idx - 1);
			Node i = im1.next;

			// disconnect
			im1.next = i.next;
			i.next = null; // ? is this really required in java?

			// summary
			this.size--;

			// return
			return i.data;

		}
	}

	// o1
	private T handleSize1Removal() {
		T temp = this.head.data;

		this.head = this.tail = null;
		this.size = 0;

		return temp;
	}
}