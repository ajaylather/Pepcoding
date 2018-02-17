package Feb17_Stack;

import java.util.Scanner;

public class Stack_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int capacity=scn.nextInt();
		Stack p1=new Stack(capacity);
		p1.push(10);
		p1.push(20);
		p1.push(30);
		p1.top();
		p1.pop();
		p1.display();
		p1.push(40);
		p1.push(50);
		p1.display();
	}

}
