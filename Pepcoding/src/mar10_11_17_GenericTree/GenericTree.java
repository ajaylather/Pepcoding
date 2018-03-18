package mar10_11_17_GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
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
			int maxchilds = max(child);
			if (maxchilds > max) {
				max = maxchilds;
			}
		}
		return max;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int height = -1;

		for (Node child : node.children) {
			int heightofchild = height(child);
			if (heightofchild > height) {
				height = heightofchild;
			}
		}
		return height + 1;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean fict = find(child, data);
			;
			if (fict == true) {
				return true;
			}
		}
		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}

		int left = 0;
		int right = node.children.size() - 1;
		while (left < right) {
			Node lnode = node.children.get(left);
			Node rnode = node.children.get(right);
			node.children.set(left, rnode);
			node.children.set(right, lnode);

			left++;
			right--;
		}
	}

	public void removeLeaves() {
		this.removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);

			if (child.children.size() == 0) {
				node.children.remove(i);
			}
		}

		for (Node child : node.children) {
			removeLeaves(child);
		}
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node lnode = node.children.remove(node.children.size() - 1);
			Node slnode = node.children.get(node.children.size() - 1);
			Node slkitail = getTail(slnode);
			slkitail.children.add(lnode);
		}
	}

	public void linearizeeff() {
		linearizeeff(root);
	}

	private Node linearizeeff(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node tail = linearizeeff(node.children.get(node.children.size() - 1));
		for (int i = node.children.size() - 2; i >= 0; i--) {
			Node currkitail = linearizeeff(node.children.get(i));
			currkitail.children.add(node.children.get(i + 1));
			node.children.remove(i + 1);
		}

		return tail;
	}

	private Node getTail(Node node) {
		if (node.children.size() == 0) {
			return node;
		} else {
			return getTail(node.children.get(0));
		}
	}

	public void flatten() {
		flatten(root);
	}

	private void flatten(Node node) {
		for (Node child : node.children) {
			flatten(child);
		}

		ArrayList<Node> newlistofc = new ArrayList<GenericTree.Node>();
		for (Node child : node.children) {
			newlistofc.add(child);
			for (Node gc : child.children) {
				newlistofc.add(gc);
			}
			child.children.clear();
		}
		node.children = newlistofc;
	}

	public void preOrder() {
		System.out.println("Pre-Order");
		preOrder(root);
	}

	private void preOrder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preOrder(child);
		}

	}

	public void postOrder() {
		System.out.println("Post-Order");
		postOrder(root);
	}

	private void postOrder(Node node) {

		for (Node child : node.children) {
			postOrder(child);
		}
		System.out.print(node.data + " ");

	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<GenericTree.Node>();
		queue.addLast(root);
		while (queue.isEmpty() == false) {
			Node node = queue.removeFirst();
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				queue.addLast(child);
			}
		}
		System.out.print(".");
	}

	public void levevOlineWise() {
		LinkedList<Node> currLevel = new LinkedList<GenericTree.Node>();
		LinkedList<Node> nextLevel = new LinkedList<GenericTree.Node>();
		currLevel.addLast(root);
		while (currLevel.size() != 0 || nextLevel.size() != 0) {
			Node node = currLevel.removeFirst();
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				nextLevel.addLast(child);
			}
			if (currLevel.size() == 0) {
				System.out.println();
				currLevel = nextLevel;
				nextLevel = new LinkedList<GenericTree.Node>();
			}
		}
	}

	public void levelOZigzag() {
		LinkedList<Node> currLevel = new LinkedList<GenericTree.Node>();
		LinkedList<Node> nextLevel = new LinkedList<GenericTree.Node>();
		currLevel.addFirst(root);
		boolean ltr = true;
		while (currLevel.size() != 0 || nextLevel.size() != 0) {
			Node node = currLevel.removeFirst();
			System.out.print(node.data + " ");
			if (ltr == true) {
				for (Node child : node.children) {
					nextLevel.addFirst(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					Node child = node.children.get(i);
					nextLevel.addFirst(child);
				}
			}
			if (currLevel.size() == 0) {
				System.out.println();
				ltr = !ltr;
				currLevel = nextLevel;
				nextLevel = new LinkedList<GenericTree.Node>();
			}
		}
	}

	private class HeapMover {
		int size = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int height = 0;
		boolean find = false;
		// int prev=-1;
		// int curr=-1;
		Node pred = null;
		Node succ = null;
		Node prev = null;
		Node curr = null;
		Node justlarger = null;

	}

	public void multiSolver(int data) {
		HeapMover mover = new HeapMover();
		multiSolver(data, 0, root, mover);
		System.out.println("Size : " + mover.size);
		System.out.println("Height : " + mover.height);
		System.out.println("Max : " + mover.max);
		System.out.println("Min : " + mover.min);
	}

	private void multiSolver(int data, int depth, Node node, HeapMover mover) {
		mover.size++;
		if (depth > mover.height) {
			mover.height = depth;
		}
		if (data == node.data) {
			mover.find = true;
		}
		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		for (Node child : node.children) {
			multiSolver(data, depth + 1, child, mover);
		}
	}

	public void predsucc(int data) {
		HeapMover mover = new HeapMover();
		predsucc(data, 0, root, mover);
		if (mover.pred == null) {
			System.out.println("Pred doesn't exist");
		} else {
			System.out.println("Pred : " + mover.pred.data);
		}
		if (mover.succ == null) {
			System.out.println("Succ doesn't exist");
		} else {
			System.out.println("Succ : " + mover.succ.data);
		}
	}

	private void predsucc(int data, int depth, Node node, HeapMover mover) {

		mover.prev = mover.curr;
		mover.curr = node;
		mover.size++;
		if (depth > mover.height) {
			mover.height = depth;
		}
		if (data == node.data) {
			mover.find = true;
			mover.pred = mover.prev;
		} else if (mover.prev != null && mover.prev.data == data) {
			mover.succ = mover.curr;
		}
		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		for (Node child : node.children) {
			predsucc(data, depth + 1, child, mover);
		}
	}

	public void justLarger(int data) {
		HeapMover mover = new HeapMover();
		justLarger(data, 0, root, mover);
		if (mover.justlarger != null) {
			System.out.println(mover.justlarger.data);
		}
	}

	private void justLarger(int data, int depth, Node node, HeapMover mover) {

		mover.prev = mover.curr;
		mover.curr = node;
		mover.size++;
		if (depth > mover.height) {
			mover.height = depth;
		}
		if (data == node.data) {
			mover.find = true;
		}
		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (node.data > data) {
			if (mover.justlarger == null) {
				mover.justlarger = node;
			} else if (node.data < mover.justlarger.data) {
				mover.justlarger = node;
			}
		}
		for (Node child : node.children) {
			justLarger(data, depth + 1, child, mover);
		}
	}

	public int kthSmallest(int k) {
		int rv = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			HeapMover mover = new HeapMover();
			justLarger(rv, 0, root, mover);
			rv = mover.justlarger.data;
		}
		return rv;
	}

	public void AreIdenticallyShaped(GenericTree other) {
		System.out.println(this.AreIdenticallyShaped(this.root, other.root));
	}

	private boolean AreIdenticallyShaped(Node nodet1, Node nodet2) {
		boolean res = true;
		if (nodet1.children.size() != nodet2.children.size()) {
			return false;
		}
		for (int i = 0; i < nodet1.children.size(); i++) {
			Node n1child = nodet1.children.get(i);
			Node n2child = nodet2.children.get(i);
			res = AreIdenticallyShaped(n1child, n2child);
			if (res == false) {
				return false;
			}
		}
		return true;
	}

	public void AreMirrorImaged(GenericTree other) {
		System.out.println(this.AreMirrorImaged(this.root, other.root));
	}

	private boolean AreMirrorImaged(Node nodet1, Node nodet2) {
		boolean res = true;
		if (nodet1.children.size() != nodet2.children.size()) {
			return false;
		}
		for (int i = 0; i < nodet1.children.size(); i++) {
			Node n1child = nodet1.children.get(i);
			Node n2child = nodet2.children.get(nodet2.children.size() - i - 1);
			res = AreMirrorImaged(n1child, n2child);
			if (res == false) {
				return false;
			}
		}
		return true;
	}

	public void IsSelfMirrorImaged() {
		System.out.println(AreMirrorImaged(root, root));
	}
	
	public void printTargetSum(Node node,int data,String asf) {
		data=data-node.data;
		asf=asf+"=>";
		if(data==0 &&node.children.size()==0) {
			System.out.println(asf);
		}
		for(Node child: node.children) {
			printTargetSum(child, data, asf);
		}
	}
}
