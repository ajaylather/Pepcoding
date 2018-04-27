package apr15_Priority_Queue_and_Huffman_Compresseion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
	private class Node implements Comparable<Node> {
		Character data;
		int freq;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}

	}

	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	public Huffman(String initialString) {
		// Step 1 - Create Frequency Map
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < initialString.length(); i++) {
			char ch = initialString.charAt(i);
			fmap.put(ch, fmap.containsKey(ch) ? fmap.get(ch) + 1 : 1);
		}

		// Step 2 - Convert to nodes and add to Priority Queue
		PriorityQueue<Node> pq = new PriorityQueue<>();
		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		for (Character key : keys) {
			Node node = new Node();
			node.data = key;
			node.freq = fmap.get(key);
			pq.add(node);
		}

		// Step 3 - Remove 2 nodes,merge them and again add it back to Priority Queue
		while (pq.size() != 1) {
			Node n1 = pq.remove();
			Node n2 = pq.remove();

			Node mergedNode = new Node();
			mergedNode.freq = n1.freq + n2.freq;
			mergedNode.left = n1;
			mergedNode.right = n2;

			pq.add(mergedNode);
		}

		// Step 4 - Retrieve Final Tree
		Node finalNode = pq.remove();

		// Step 5 - Traverse and fill the encoder and decoder
		traverse(finalNode, "");
	}

	private void traverse(Node finalNode, String asf) {
		if (finalNode == null) {
			return;
		}

		if (finalNode.left == null && finalNode.right == null) {
			encoder.put(finalNode.data, asf);
			decoder.put(asf, finalNode.data);
		}

		traverse(finalNode.left, asf + "0");
		traverse(finalNode.right, asf + "1");
	}

	public String encode(String str) {
		String ans = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			ans += encoder.get(ch);
		}

		return ans;
	}

	public String decode(String str) {
		String decodedString = "";

		String prefix = "";
		for (int i = 0; i < str.length(); i++) {
			prefix += str.charAt(i);

			if (decoder.containsKey(prefix)) {
				decodedString += decoder.get(prefix);
				prefix = "";
			}
		}

		return decodedString;
	}
}