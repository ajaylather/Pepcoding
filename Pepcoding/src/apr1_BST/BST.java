package apr1_BST;

import java.util.*;

public class BST {
	public class Node {
		int data;
		Node left;
		Node right;
	}

	public Node root;
	int size;

	public BST(int[] sa) {
		this.root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		Node rootnode = new Node();
		int mid = (lo + hi) / 2;
		rootnode.data = sa[mid];
		rootnode.left = construct(sa, lo, mid - 1);
		rootnode.right = construct(sa, mid + 1, hi);
		return rootnode;
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

	public void add(int data) {
		if (this.root == null) {
			this.root = new Node();
			root.data = data;
			this.size++;
		} else
			add(this.root, data);
	}

	private void add(Node node, int data) {
		if (data < node.data) {
			if (node.left == null) {
				node.left = new Node();
				node.left.data = data;
				this.size++;
			} else {
				add(node.left, data);
			}
		} else if (data > node.data) {
			if (node.right == null) {
				node.right = new Node();
				node.right.data = data;
				this.size++;
			} else {
				add(node.right, data);
			}
		} else
			return;
	}

	public void remove(int data) {
		this.remove(null, this.root, false, data);
	}

	private void remove(Node parent, Node child, boolean ilc, int data) {
		if (child.data == data) {
			// work area
			if (child.left == null && child.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				this.size--;
			}
			else if (child.left == null ^ child.right == null) {
				if (child.left == null) {
					if (ilc) {
						parent.left = child.right;
					} else {
						parent.right = child.right;
					}
				} else {
					if (ilc) {
						parent.left = child.left;
					} else {
						parent.right = child.left;
					}
				}
				this.size--;
			} 
			else {
				int lkamax = max(child.left);
				child.data = lkamax;
				remove(child, child.left, true, lkamax);
			}

		}
		if (data < child.data) {
			remove(child, child.left, true, data);
		} else if (data > child.data) {
			remove(child, child.right, false, data);
		}
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
		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}
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
		if (data > node.data) {
			return find(data, node.right);
		} else if (data < node.data) {
			return find(data, node.left);
		} else {
			return true;
		}
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
		LinkedList<Pair> stack = new LinkedList<BST.Pair>();
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
		LinkedList<Pair> stack = new LinkedList<BST.Pair>();
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
		LinkedList<Pair> stack = new LinkedList<BST.Pair>();
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
		LinkedList<levelPair> queue = new LinkedList<BST.levelPair>();
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

	public int lcaTree(int d1, int d2) {// least common ancestor using properties of tree
		return this.lcaTree(d1, d2, this.root).data;
	}

	private Node lcaTree(int d1, int d2, Node node) {
		if (node == null) {
			return null;
		}
		if (node.data == d1 || node.data == d2) {
			return node;
		}
		Node llca = this.lcaTree(d1, d2, node.left);
		Node rlca = this.lcaTree(d1, d2, node.right);
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

	public void lcaBST(int d1, int d2) {// least common ancestor using properties of tree
		this.lcaBST(d1, d2, this.root);
	}

	private void lcaBST(int d1, int d2, Node node) {
		if (node.data < d1 && node.data < d2) {
			lcaBST(d1, d2, node.right);
		} else if (node.data > d1 && node.data > d2) {
			lcaBST(d1, d2, node.left);
		} else {
			System.out.println(node.data);
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

	public void printInRange(int lo, int hi) {
		this.printInRange(this.root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else if (node.data > lo && node.data < hi) {
			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		} else
			printInRange(node.left, lo, hi);
		// if (node.data > hi) {
		// printInRange(node.left, lo, hi);
		// }

	}

	public class heapMover {
		int sum;
	}

	public void replaceWithSumOfLargerNodes() {
		heapMover mover = new heapMover();
		mover.sum = 0;
		this.replaceWithSumOfLargerNodes(mover, this.root);
	}

	private void replaceWithSumOfLargerNodes(heapMover mover, Node node) {
		if (node == null) {
			return;
		}
		replaceWithSumOfLargerNodes(mover, node.right);
		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;
		replaceWithSumOfLargerNodes(mover, node.left);
	}

	public void pairSumTarget(int targetSum) {
		ArrayList<Integer> list = new ArrayList<>();
		this.pairSumTarget(targetSum, this.root, list);
		// Collections.sort(list); //required only if tree is binary tree
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
}
