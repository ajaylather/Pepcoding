package mar18_BinaryTree;

import java.util.Scanner;

public class BinaryTree {
	private class Node{
		int data;
		Node left;
		Node right;
	}
	private Node root;
	int size;
	
	private BinaryTree() {
		this.root=null;
		this.size=0;
	}
	
	private Node takeInput(Scanner scn,Node parent,boolean ilc) {
		
		if(parent==null) {
			System.out.println("Rnter the data for root node");
		}else {
			System.out.println("Enter the data for "+parent.data);
		}
		
		Node child=new Node();
		int data =scn.nextInt();
		child.data = data;
		
		System.out.println("Do you have any left child?");
		boolean hlc=scn.nextBoolean();
		
		if(hlc==true) {
			child.left=takeInput(scn, child, true);
		}else {
			child.left=null;
		}
		
		System.out.println("Do you have any right child?");
		boolean hrc=scn.nextBoolean();
		
		if(hrc==true) {
			child.right=takeInput(scn, child, false);
		}else {
			child.right=null;
		}
		
		return child;
	}
	private int size() {
		return this.size;
	}
	
	private boolean isEmpty() {
		return this.size()==0;
	}
	
	public void display() {
		this.display(root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print("<=" + node.right.data);
		} else {
			System.out.print("<=END");
		}
		System.out.println();
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}
	}
}
