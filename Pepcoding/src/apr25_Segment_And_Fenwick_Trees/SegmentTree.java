package apr25_Segment_And_Fenwick_Trees;

public class SegmentTree {
	private class Node {
		int ssi;
		int sei;
		int data;
		Node left;
		Node right;
	}

	Node root;

	public SegmentTree(int[] arr) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		// TODO Auto-generated method stub
		if (lo == hi) {
			Node bn = new Node();
			bn.ssi = lo;
			bn.sei = hi;
			bn.data = arr[lo];
			return bn;
		}

		int mid = (lo + hi) / 2;
		Node node = new Node();
		node.ssi = lo;
		node.sei = hi;
		node.left = construct(arr, lo, mid);
		node.right = construct(arr, mid + 1, hi);
		node.data = node.left.data + node.right.data;
		return node;
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

	public void update(int idx, int delta) {
		this.update(this.root, idx, delta);
	}

	private void update(Node node, int idx, int delta) {
		// TODO Auto-generated method stub
		if (idx >= node.ssi && idx <= node.sei) {
			if (idx == node.ssi) {
				node.data += delta;
				return;
			}
			update(node.left, idx, delta);
			update(node.right, idx, delta);
			node.data = node.left.data + node.right.data;
		}
	}

	public int query(int qsi, int qei) {
		return this.query(this.root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {
		// TODO Auto-generated method stub
		if (node.ssi >= qsi && node.sei <= qei) {
			return node.data;
		} else if (node.ssi > qei || node.sei < qsi) {
			return 0;
		} else {
			int qctoleft = query(node.left, qsi, qei);
			int qctoright = query(node.right, qsi, qei);
			return qctoleft + qctoright;
		}
	}

}
