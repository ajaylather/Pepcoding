package mar10_GenericTre;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	Node root;
	int size;

	public GenericTree() {
		this.root = this.takeInput(new Scanner(System.in), null, -1);
	}

	public Node takeInput(Scanner scn, Node parent, int ci) {

		// Prompt the user
		if (parent == null) {
			System.out.println("Enter the data for root : ");
		} else {
			System.out.println("Enter the data of " + ci + "th child of " + parent.data + " :");
		}

		// Take data from user
		int data = scn.nextInt();

		// Take number of child from user
		System.out.println("Enter the number of children of " + data);
		int GChild = scn.nextInt();

		// Create the node
		Node child = new Node();
		this.size++;

		// Set the data
		child.data = data;

		// Create child for node
		for (int i = 0; i < GChild; i++) {
			Node gc = takeInput(scn, child, i);
			child.children.add(gc);
		}
		// Return
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		String str = node.data + "=>";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
		// String str="";
		// for(int i=0;i<node.children.size();i++) {
		// str+=node.children.get(i).data+", ";
		// }
		// System.out.println(node.data+"=>"+str+".");
		// for(Node child: node.children) {
		// display(child);
		// }
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int sz = 1;
		int childsizes = 0;
		for (Node child : node.children) {
			childsizes += size2(child);
		}
		return sz + childsizes;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int max = Integer.MIN_VALUE;
		if (node.data > max) {
			max = node.data;
		}
		for (Node child : node.children) {
			int maxchilds=max(child);
			if(maxchilds>max) {
				max=maxchilds;
			}
		}
		return max;
	}

	public int height() {
		return this.height(this.root);
	}
	
	private int height(Node node) {
		int height=-1;
		
		for(Node child :node.children) {
			int heightofchild=height(child);
			if(heightofchild>height) {
				height=heightofchild;
			}
		}
		return height+1;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean fict=find(child, data);;
			if(fict==true) {
				return true;
			}
		}
		return false;
	}
}
