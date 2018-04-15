package apr8_Hashmap_Application;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		HashMap<Character, Node> children = new HashMap<>();
		boolean eow;
	}

	private Node root;
	private int numWords = 0;
	private int numNodes = 0;

	public Trie() {
		this.root = new Node();
		this.root.data = '$';

	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			if (node.eow == false) {
				node.eow = true;
				this.numWords++;
			}
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		Node child = node.children.get(ch);
		if (child == null) {
			child = new Node();
			child.data = ch;
			node.children.put(ch, child);
			this.numNodes++;
		}
		addWord(child, row);
	}

	public boolean searchWord(String word) {
		return this.searchWord(this.root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0) {
			return node.eow;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		Node child = node.children.get(ch);
		if (child == null) {
			return false;
		}
		return searchWord(child, row);
	}

	public void removeWord(String word) {
		this.removeWord(this.root, word);
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			if (node.eow == true) {
				node.eow = false;
				this.numWords--;
			}
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		Node child = node.children.get(ch);
		if (child == null) {
			return;
		}
		removeWord(child, row);
		if (child.children.size() == 0 && child.eow == false) {
			node.children.remove(ch);
			this.numNodes--;
		}
	}

	public void displayAsTree() {
		this.displayAsTree(this.root);
	}

	private void displayAsTree(Node node) {
		ArrayList<Character> childrenarr=new ArrayList<>(node.children.keySet());
		System.out.println(node.data+"=>"+childrenarr);
		for(Character childs: childrenarr) {
			Node child=node.children.get(childs);
			displayAsTree(child);
		}
	}
	
	public void displayAllWords() {
		this.displayAllWords(this.root,"");
	}

	private void displayAllWords(Node node,String wsf) {
		if(node.eow) {
			System.out.println(wsf);
		}
		ArrayList<Character> childrenarr=new ArrayList<>(node.children.keySet());
		for(Character childs: childrenarr) {
			Node child=node.children.get(childs);
			displayAllWords(child,wsf+childs);
		}
	}
}
