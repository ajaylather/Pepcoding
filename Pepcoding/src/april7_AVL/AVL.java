package april7_AVL;

import apr1_BST.BST.Node;

public class AVL {
	public class Node {
		int data;
		Node left;
		Node right;
		int height;
	}

	public Node root;
	int size;

	public AVL(int[] sa) {
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
		rootnode.height = Math.max((rootnode.left == null ? 0 : rootnode.left.height + 1),
				(rootnode.right == null ? 0 : rootnode.right.height + 1));
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

	private Node add(Node node, int data) {
		if (node == null) {
			Node temp = new Node();
			temp.data = data;
			temp.height = 0;
			this.size++;
			return temp;
		}
		if (data > node.data) {
			node.right = add(node.right, data);
		} else if (data < node.data) {
			node.left = add(node.left, data);
		} else {
			// nothing
		}
		node.height = height(node);
		int bal = balanceFactor(node);
		if (bal < -1 || bal > 1) {
			// 4 cases i.e. ll,le,el,ee
			if (bal > 0) {
				// ll and lr
				if (data < node.left.data) {
					// case ll
					node = rightRotate(node);
				} else {
					// case lr
					node.left = leftRotate(node.left);
					node = rightRotate(node);
				}
			} else {
				// case rr and rl
				if (data > node.right.data) {
					// case rr
					node = leftRotate(node);
				} else {
					// case rl
					node.right = rightRotate(node.right);
					node = leftRotate(node);
				}
			}
		}
		return node;
	}

	public void remove(int data) {
		this.remove(this.root, data);
	}

	private Node remove(Node node, int data) {
		if (data < node.data) {
			node.left = remove(node.left, data);
		} else if (data > node.data) {
			node.right = remove(node.right, data);
		} else {
			if (node.left == null || node.right == null) {
				node = node.left != null ? node.left : node.right;
			} else {
				int lkamax = max(node.left);
				node.data = lkamax;
				node.left = remove(node.left, lkamax);
			}
		}
		if(node==null) {
			return null;
		}
		node.height = height(node);
		int bal = balanceFactor(node);
		if (bal < -1 || bal > 1) {
			// 4 cases i.e. ll,le,el,ee
			if (bal > 0) {
				// case ll and lr
				int lbal = balanceFactor(node.left);
				if (lbal >= 0) {
					// case ll
					node = rightRotate(node);
				} else {
					// case lr
					node.left = leftRotate(node.left);
					node = rightRotate(node);
				}
			} else {
				// case rr and rl
				int rbal = balanceFactor(node.right);
				if (rbal < 0) {
					// case rr
					node = leftRotate(node);
				} else {
					// case rl
					node.right = rightRotate(node.right);
					node = leftRotate(node);
				}
			}
		}
		return node;
	}
	// private void remove(Node parent, Node child, boolean ilc, int data) {
	// if (child.data == data) {
	// // work area
	// if (child.left == null && child.right == null) {
	// if (ilc) {
	// parent.left = null;
	// } else {
	// parent.right = null;
	// }
	// this.size--;
	// } else if (child.left == null ^ child.right == null) {
	// if (child.left == null) {
	// if (ilc) {
	// parent.left = child.right;
	// } else {
	// parent.right = child.right;
	// }
	// } else {
	// if (ilc) {
	// parent.left = child.left;
	// } else {
	// parent.right = child.left;
	// }
	// }
	// this.size--;
	// } else {
	// int lkamax = max(child.left);
	// child.data = lkamax;
	// remove(child, child.left, true, lkamax);
	// }
	//
	// }
	// if (data < child.data) {
	// remove(child, child.left, true, data);
	// } else if (data > child.data) {
	// remove(child, child.right, false, data);
	// }
	// }

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
		} else {
			return Math.max((node.left == null ? 0 : node.left.height + 1),
					(node.right == null ? 0 : node.right.height + 1));
		}
	}

	private int balanceFactor(Node node) {
		int lh = height(node.left);
		int rh = height(node.right);
		return lh - rh;
	}

	private Node rightRotate(Node z) {
		Node y = z.left;
		Node t3 = y.right;
		y.right = z;
		z.left = t3;

		z.height = height(z);
		y.height = height(y);
		return y;
	}

	private Node leftRotate(Node z) {
		Node y = z.right;
		Node t2 = y.left;
		y.left = z;
		z.right = t2;

		z.height = height(z);
		y.height = height(y);
		return y;
	}
}
