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
	
	public void mirror(){
		mirror(root);
	}
	
	private void mirror(Node node){
		for(Node child: node.children){
			mirror(child);
		}
		
		
		int left = 0; 
		int right = node.children.size() - 1;
		while(left < right){
			Node lnode = node.children.get(left);
			Node rnode = node.children.get(right);
			node.children.set(left, rnode);
			node.children.set(right, lnode);
			
			left++;
			right--;
		}
	}

	public void removeLeaves(){
		this.removeLeaves(root);
	}
	
	private void removeLeaves(Node node){
		for(int i = node.children.size() - 1; i >= 0; i--){
			Node child = node.children.get(i);
			
			if(child.children.size() == 0){
				node.children.remove(i);
			}
		}
		
		for(Node child: node.children){
			removeLeaves(child);
		}
	}

	public void linearize(){
		linearize(root);
	}
	
	private void linearize(Node node){
		for(Node child: node.children){
			linearize(child);
		}

		while(node.children.size() > 1){
			Node lnode = node.children.remove(node.children.size() - 1);
			Node slnode = node.children.get(node.children.size() - 1);
			Node slkitail = getTail(slnode);
			slkitail.children.add(lnode);
		}
	}

	public void linearizeeff(){
		linearizeeff(root);
	}
	
	private Node linearizeeff(Node node){
		if(node.children.size() == 0){
			return node;
		}
		
		Node tail = linearizeeff(
						node.children.get(node.children.size() - 1));
		for(int i = node.children.size() - 2; i >= 0; i--){
			Node currkitail = linearizeeff(node.children.get(i));
			currkitail.children.add(node.children.get(i + 1));
			node.children.remove(i + 1);
		}
		
		return tail;
	}

	private Node getTail(Node node){
		if(node.children.size() == 0){
			return node;
		} else {
			return getTail(node.children.get(0));
		}
	}

	public void flatten(){
		flatten(root);
	}
	
	private void flatten(Node node){
		for(Node child: node.children){
			flatten(child);
		}
		
		ArrayList<Node> newlistofc = new ArrayList<GenericTree.Node>();
		for(Node child: node.children){
			newlistofc.add(child);
			for(Node gc: child.children){
				newlistofc.add(gc);
			}
			child.children.clear();
		}
		
		node.children = newlistofc;
	}
}
