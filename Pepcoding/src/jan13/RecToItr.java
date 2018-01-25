package jan13;

import java.util.ArrayList;

public class RecToItr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Printss("abc", "");
		PrintBoardPath(0, 10);
	}

	public static void Printss(String ques, String ans) {
		Node root = new Node(ques, ans);
		ArrayList<Node> stack = new ArrayList<Node>();
		stack.add(root);
		while (stack.size() > 0) {
			Node nodeattop = stack.get(stack.size() - 1);
			if (nodeattop.IsLeftDone == false) {
				nodeattop.IsLeftDone = true;
				if (nodeattop.ques.length() > 0) {
					Node right = new Node(nodeattop.ques.substring(1), nodeattop.ans);
					stack.add(right);
				}

			} else if (nodeattop.IsSelfDone == false) {
				nodeattop.IsSelfDone = true;
				if (nodeattop.ques.length() == 0) {
					System.out.println(nodeattop.ans);
				}
			} else if (nodeattop.IsRightDone == false) {
				nodeattop.IsRightDone = true;
				if (nodeattop.ques.length() > 0) {
					Node right = new Node(nodeattop.ques.substring(1), nodeattop.ans + nodeattop.ques.charAt(0));
					stack.add(right);
				}
			} else {
				stack.remove(stack.size() - 1);
			}
		}
	}

	private static class Node {
		String ques;
		String ans;
		boolean IsLeftDone;
		boolean IsSelfDone;
		boolean IsRightDone;

		private Node(String ques, String ans) {
			this.ques = ques;
			this.ans = ans;
		}
	}

	public static void PrintBoardPath(int curr, int end) {
		NodeGT root = new NodeGT(curr, end, "");
		ArrayList<NodeGT> stack = new ArrayList<NodeGT>();
		stack.add(root);
		while (stack.size() > 0) {
			NodeGT nattop = stack.get(stack.size() - 1);
			if (nattop.dicevaldone < nattop.tdicevals) {
				nattop.dicevaldone++;
				if (nattop.dicevaldone + nattop.curr <= end) {
					NodeGT child = new NodeGT(nattop.dicevaldone + nattop.curr, end, nattop.psf + nattop.dicevaldone);
					stack.add(child);
				}
			} else if (!nattop.isselfdone) {
				nattop.isselfdone = true;
				if (nattop.curr == nattop.end) {
					System.out.println(nattop.psf);
				}
			} else {
				stack.remove(stack.size() - 1);
			}

		}
	}

	public static class NodeGT {
		int dicevaldone = 0;
		int tdicevals = 6;
		boolean isselfdone;
		int curr = 0;
		int end = 0;
		String psf = "";

		private NodeGT(int curr, int end, String psf) {
			this.curr = curr;
			this.end = end;
			this.psf = psf;
		}
	}
}
