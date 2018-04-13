package mar18_BinaryTree;

import java.util.*;

import apr1_BST.BST.Node;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	int size;

	public BinaryTree() {
		this.root = takeInput(new Scanner(System.in), null, false);
	}

	public BinaryTree(int[] preOrder, int[] inOrder) {
		this.root = this.construct(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}

	public BinaryTree(int[] postOrder, int[] inOrder, int i) {
		this.root = this.construct2(postOrder, inOrder, 0, postOrder.length - 1, 0, inOrder.length - 1);
	}

	private Node takeInput(Scanner scn, Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (ilc == true) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		Node child = new Node();
		int data = scn.nextInt();
		child.data = data;
		this.size++;

		System.out.println("Do you have any left child?");
		boolean hlc = scn.nextBoolean();

		if (hlc == true) {
			child.left = takeInput(scn, child, true);
		} else {
			child.left = null;
		}

		System.out.println("Do you have any right child?");
		boolean hrc = scn.nextBoolean();

		if (hrc == true) {
			child.right = takeInput(scn, child, false);
		} else {
			child.right = null;
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println("*******************");
		this.display(root);
		System.out.println("*******************");
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += ". =>";
		} else {
			str += node.left.data + "=>";
		}
		str += node.data;

		if (node.right == null) {
			str += "<=.";
		} else {
			str += "<=" + node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int lkasize = 0;
		int rkasize = 0;
		if (node.left != null) {
			lkasize = size2(node.left);
		}
		if (node.right != null) {
			rkasize = size2(node.right);
		}
		int size = lkasize + rkasize + 1;
		return size;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lkamax = max(node.left);
		int rkamax = max(node.right);
		int max = Math.max(node.data, Math.max(lkamax, rkamax));
		return max;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int lheight = height(node.left);
		int rheight = height(node.right);
		int height = Math.max(lheight, rheight) + 1;
		return height;
	}

	public boolean find(int data) {
		return this.find(data, this.root);
	}

	private boolean find(int data, Node node) {
		if (node == null) {
			return false;
		}
		boolean rv = node.data == data || find(data, node.left) || find(data, node.right);
		return rv;
	}

	public void preOrder() {
		this.preOrder(this.root);
		System.out.println();
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		this.inOrder(this.root);
		System.out.println();
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void postOrder() {
		this.postOrder(this.root);
		System.out.println();
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	private class Pair {
		Node node;
		boolean isSelfDone;
		boolean hasCalledLeft;
		boolean hasCalledRight;
	}

	public void preOrderIter() {
		LinkedList<Pair> stack = new LinkedList<BinaryTree.Pair>();
		Pair rootp = new Pair();
		rootp.node = root;

		stack.push(rootp);
		while (stack.size() > 0) {
			Pair tosp = stack.getFirst();
			if (tosp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tosp.isSelfDone == false) {
				System.out.print(tosp.node.data + "->");
				tosp.isSelfDone = true;

			} else if (tosp.hasCalledLeft == false) {
				tosp.hasCalledLeft = true;
				Pair lp = new Pair();
				lp.node = tosp.node.left;
				stack.addFirst(lp);

			} else if (tosp.hasCalledRight == false) {
				tosp.hasCalledRight = true;
				Pair rp = new Pair();
				rp.node = tosp.node.right;
				stack.addFirst(rp);
			} else {
				stack.removeFirst();
			}
		}
	}

	public void postOrderIter() {
		LinkedList<Pair> stack = new LinkedList<BinaryTree.Pair>();
		Pair rootp = new Pair();
		rootp.node = root;

		stack.push(rootp);
		while (stack.size() > 0) {
			Pair tosp = stack.getFirst();
			if (tosp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tosp.hasCalledLeft == false) {
				tosp.hasCalledLeft = true;
				Pair lp = new Pair();
				lp.node = tosp.node.left;
				stack.addFirst(lp);

			} else if (tosp.hasCalledRight == false) {
				tosp.hasCalledRight = true;
				Pair rp = new Pair();
				rp.node = tosp.node.right;
				stack.addFirst(rp);
			} else if (tosp.isSelfDone == false) {
				System.out.print(tosp.node.data + "->");
				tosp.isSelfDone = true;

			} else {
				stack.removeFirst();
			}
		}
	}

	public void inOrderIter() {
		LinkedList<Pair> stack = new LinkedList<BinaryTree.Pair>();
		Pair rootp = new Pair();
		rootp.node = root;

		stack.push(rootp);
		while (stack.size() > 0) {
			Pair tosp = stack.getFirst();
			if (tosp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tosp.hasCalledLeft == false) {
				tosp.hasCalledLeft = true;
				Pair lp = new Pair();
				lp.node = tosp.node.left;
				stack.addFirst(lp);

			} else if (tosp.isSelfDone == false) {
				System.out.print(tosp.node.data + "->");
				tosp.isSelfDone = true;

			} else if (tosp.hasCalledRight == false) {
				tosp.hasCalledRight = true;
				Pair rp = new Pair();
				rp.node = tosp.node.right;
				stack.addFirst(rp);
			} else {
				stack.removeFirst();
			}
		}
	}

	private class levelPair {
		Node node;
		int level;
	}

	public void levelOrderIter() {
		LinkedList<levelPair> queue = new LinkedList<BinaryTree.levelPair>();
		levelPair rootp = new levelPair();
		rootp.node = this.root;
		queue.addLast(rootp);

		while (queue.size() > 0) {
			levelPair removedp = queue.removeFirst();
			System.out.println(removedp.node.data + "->");
			if (removedp.node.left != null) {
				levelPair lp = new levelPair();
				queue.addLast(lp);
				lp.node = removedp.node.left;
				queue.removeFirst();
			}

			if (removedp.node.right != null) {
				levelPair rp = new levelPair();
				queue.addLast(rp);
				rp.node = removedp.node.right;
				queue.removeFirst();
			}
		}
	}

	public int diameter() {
		return this.diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		// distance between deepest node of left side and deepest node of right side
		int f1 = lh + rh + 2;
		// diameter of left side tree
		int f2 = diameter(node.left);
		// diameter of right side tree
		int f3 = diameter(node.right);

		int d = Math.max(f1, Math.max(f2, f3));
		return d;
	}

	private class diaPair {
		int height;
		int diameter;
	}

	public int diameter2() {
		diaPair dp = diameter2(this.root);
		return dp.diameter;
	}

	private diaPair diameter2(Node node) {
		if (node == null) {
			diaPair bp = new diaPair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}

		diaPair left = diameter2(node.left);
		diaPair right = diameter2(node.right);
		diaPair mp = new diaPair();
		mp.height = Math.max(left.height, right.height) + 1;
		int f1 = left.height + right.height + 2;
		int f2 = left.diameter;
		int f3 = right.diameter;
		mp.diameter = Math.max(f1, Math.max(f2, f3));
		return mp;
	}

	private class balancedPair {
		boolean IsBalanced;
		int height;
	}

	public boolean isBalanced() {
		return isBalanced(this.root);

	}

	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		boolean ilb = isBalanced(node.left);
		boolean irb = isBalanced(node.right);
		return ilb == true && irb == true && Math.abs(lh - rh) <= 1;
	}

	public boolean isBalanced2() {
		return this.isBalanced2(this.root).IsBalanced;
	}

	private balancedPair isBalanced2(Node node) {
		if (node == null) {
			balancedPair bp = new balancedPair();
			bp.height = -1;
			bp.IsBalanced = true;
			return bp;
		}
		balancedPair lp = isBalanced2(node.left);
		balancedPair rp = isBalanced2(node.right);
		balancedPair mp = new balancedPair();

		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.IsBalanced = lp.IsBalanced == true && rp.IsBalanced == true && Math.abs(lp.height - rp.height) <= 1;
		return mp;
	}

	private class bstPair {
		int min;
		int max;
		boolean IsBST;
	}

	public boolean isBST() {
		return this.isBST(this.root).IsBST;
	}

	private bstPair isBST(Node node) {
		if (node == null) {
			bstPair bp = new bstPair();
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.IsBST = true;
			return bp;
		}
		bstPair lp = isBST(node.left);
		bstPair rp = isBST(node.right);
		bstPair mp = new bstPair();
		int lmin = lp.min;
		int lmax = lp.max;
		int rmin = rp.min;
		int rmax = rp.max;

		mp.min = Math.min(node.data, Math.min(lmin, rmin));
		mp.max = Math.max(node.data, Math.max(lmax, rmax));
		mp.IsBST = lp.IsBST == true && rp.IsBST == true && (node.data > lp.max && node.data < rp.min);
		return mp;
	}

	private class largestBSTPair {
		boolean IsBST;
		int min;
		int max;
		Node largestBSTroot;
		int largestBSTsize;

	}

	public void largestBST() {
		System.out.println(largestBST(this.root).largestBSTroot.data);
		System.out.println(largestBST(this.root).largestBSTsize);
	}

	private largestBSTPair largestBST(Node node) {
		if (node == null) {
			largestBSTPair bp = new largestBSTPair();
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.IsBST = true;
			return bp;
		}
		largestBSTPair lp = largestBST(node.left);
		largestBSTPair rp = largestBST(node.right);
		largestBSTPair mp = new largestBSTPair();
		int lmin = lp.min;
		int lmax = lp.max;
		int rmin = rp.min;
		int rmax = rp.max;

		mp.min = Math.min(node.data, Math.min(lmin, rmin));
		mp.max = Math.max(node.data, Math.max(lmax, rmax));
		mp.IsBST = lp.IsBST == true && rp.IsBST == true && (node.data > lp.max && node.data < rp.min);

		if (mp.IsBST == true) {
			mp.largestBSTroot = node;
			mp.largestBSTsize = lp.largestBSTsize + rp.largestBSTsize + 1;
		} else {
			if (lp.largestBSTsize > rp.largestBSTsize) {
				mp.largestBSTroot = lp.largestBSTroot;
				mp.largestBSTsize = lp.largestBSTsize;
			} else {
				mp.largestBSTroot = rp.largestBSTroot;
				mp.largestBSTsize = rp.largestBSTsize;
			}
		}
		return mp;
	}

	private Node construct(int[] pre, int[] in, int psi, int pei, int insi, int inei) {
		if (psi > pei || insi > inei) {
			return null;
		}

		Node rootnode = new Node();
		int idx = -1;
		for (int i = insi; i <= inei; i++) {
			idx = i;
			if (pre[psi] == in[i]) {
				break;
			}
		}

		int numOfLeftElements = idx - insi;
		rootnode.data = in[idx];// data present at idx in inorder
		rootnode.left = this.construct(pre, in, psi + 1, psi + numOfLeftElements, insi, idx - 1);
		rootnode.right = this.construct(pre, in, psi + numOfLeftElements + 1, pei, idx + 1, inei);
		return rootnode;
	}

	private Node construct2(int[] post, int[] in, int psi, int pei, int insi, int inei) {
		if (psi > pei || insi > inei) {
			return null;
		}

		Node rootnode = new Node();
		int idx = -1;
		for (int i = insi; i <= inei; i++) {
			idx = i;
			if (post[pei] == in[i]) {
				break;
			}
		}

		int numOfElements = idx - insi;
		rootnode.data = post[pei];// data present at idx in inorder
		rootnode.right = this.construct2(post, in, psi + numOfElements, pei - 1, idx + 1, inei);
		rootnode.left = this.construct2(post, in, psi, psi + numOfElements - 1, insi, idx - 1);
		return rootnode;
	}

	public int lca(int d1, int d2) {
		return this.lca(d1, d2, this.root).data;
	}

	private Node lca(int d1, int d2, Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == d1 || node.data == d2) {
			return node;
		}
		Node llca = this.lca(d1, d2, node.left);
		Node rlca = this.lca(d1, d2, node.right);
		if (llca != null && rlca != null) {
			return node;
		} else if (llca != null) {
			return llca;
		} else if (rlca != null) {
			return rlca;
		} else {
			return null;
		}
	}

	public void removeLeaves() {
		this.removeLeaves(null, this.root, false);
	}

	private void removeLeaves(Node parent, Node child, boolean ilc) {
		if (child == null) {
			return;
		}
		if (child.left == null && child.right == null) {
			if (ilc == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}
		removeLeaves(child, child.left, true);
		removeLeaves(child, child.right, false);

	}

	public void siblingLess() {
		this.siblingLess(null, this.root, false);
	}

	private void siblingLess(Node parent, Node child, boolean ilc) {
		if (child == null) {
			return;
		}
		if (parent == null) {
			System.out.println(child.data);
			return;
		}
		if (parent.right == null && ilc == true) {
			System.out.println(parent.left.data);
		}
		if (parent.left == null && ilc == false) {
			System.out.println(parent.right.data);
		}
		siblingLess(child, child.left, true);
		siblingLess(child, child.right, false);
	}

	public ArrayList<Integer> pathFromRoot(int data) {
		return this.pathFromRoot(this.root, data);
	}

	private ArrayList<Integer> pathFromRoot(Node node, int data) {
		if (node == null) {
			return new ArrayList<Integer>();
		}
		if (node.data == data) {
			ArrayList<Integer> br = new ArrayList<Integer>();
			br.add(data);
			return br;
		}
		ArrayList<Integer> lp = pathFromRoot(node.left, data);
		if (lp.size() > 0) {
			lp.add(node.data);
			return lp;
		}
		ArrayList<Integer> rp = pathFromRoot(node.right, data);
		if (rp.size() > 0) {
			rp.add(node.data);
			return rp;
		}
		return new ArrayList<Integer>();
	}

	private ArrayList<Node> pathFromRootInNodes(Node node, int data) {
		if (node == null) {
			return new ArrayList<Node>();
		}
		if (node.data == data) {
			ArrayList<Node> br = new ArrayList<Node>();
			br.add(node);
			return br;
		}
		ArrayList<Node> lp = pathFromRootInNodes(node.left, data);
		if (lp.size() > 0) {
			lp.add(node);
			return lp;
		}
		ArrayList<Node> rp = pathFromRootInNodes(node.right, data);
		if (rp.size() > 0) {
			rp.add(node);
			return rp;
		}
		return new ArrayList<Node>();
	}

	public void pairSumTarget(int targetSum) {
		ArrayList<Integer> list = new ArrayList<>();
		this.pairSumTarget(targetSum, this.root, list);
		Collections.sort(list); // not required if tree is bst
		int left = 0;
		int right = list.size() - 1;
		while (left < right) {
			if (list.get(left) + list.get(right) > targetSum) {
				right--;
			} else if (list.get(left) + list.get(right) < targetSum) {
				left++;
			} else {
				System.out.println(list.get(left) + " " + list.get(right));
				left++;
				right--;
			}
		}
	}

	private void pairSumTarget(int targetSum, Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		pairSumTarget(targetSum, node.left, list);
		list.add(node.data);
		pairSumTarget(targetSum, node.right, list);
	}

	public void targetLeafPath(int tar) {
		this.targetLeafPath(this.root, tar, 0, "");
	}

	private void targetLeafPath(Node node, int tar, int ssf, String psf) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			if (ssf + node.data == tar) {
				psf = psf + " " + node.data;
				System.out.println(psf);
			}
			return;
		}
		targetLeafPath(node.left, tar, ssf + node.data, psf + " " + node.data);
		targetLeafPath(node.right, tar, ssf + node.data, psf + " " + node.data);
	}

	private void printKdown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.print(node.data + " ");
			return;
		}
		printKdown(node.left, k - 1);
		printKdown(node.right, k - 1);
	}

	public void printKfar(int data, int k) {

		ArrayList<Node> pathFromRoot = pathFromRootInNodes(root, data);
		ArrayList<Boolean> directionlist = new ArrayList<Boolean>();
		directionlist.add(null);

		for (int i = 1; i < pathFromRoot.size(); i++) {
			Node parent = pathFromRoot.get(i);
			Node child = pathFromRoot.get(i - 1);
			directionlist.add(parent.left == child);
		}

		for (int i = 0; i < pathFromRoot.size(); i++) {
			Node temp = pathFromRoot.get(i);
			if (i == 0) {
				printKdown(temp, k);
			} else if (k == i) {
				System.out.println(temp.data);
			} else {
				if (directionlist.get(i) == false) {
					printKdown(temp.left, k - i - 1);
				} else {
					printKdown(temp.right, k - i - 1);
				}
			}
		}
	}
}
