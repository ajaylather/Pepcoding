package feb17_Stack_and_Queue;

import java.util.Arrays;

public class Stack {

	int[] data;
	int tos = -1;

	public Stack(int capacity) {
		this.data = new int[capacity];
	}

	public Stack() {
		this(5);
	}

	public Stack(int[] arr) {	//this will add reverse elements in stack
		this.data=new int[arr.length];
		//this.data=Arrays.copyOf(arr, arr.length);
		this.tos=arr.length-1;
	}
	
	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		// if (this.tos == -1) {
		// return true;
		// } else
		// return false;
		return this.size() == 0;
	}

	public void push(int value) {
		if (this.tos == this.data.length - 1) {
			System.out.println("Stack Is Full");
			return;
		}
		this.tos++;
		this.data[this.tos] = value;
	}

	public int pop() {
		if (this.tos == -1) {
			System.out.println("Stack Is Empty");
			return 0;
		}
		int deldata = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return deldata;
	}

	public int top() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return 0;
		}
		return this.data[this.tos];
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + "->");
		}
		System.out.println("End");
	}
}
