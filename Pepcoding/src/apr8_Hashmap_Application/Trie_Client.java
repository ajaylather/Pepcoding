package apr8_Hashmap_Application;

public class Trie_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.addWord("art");
		trie.addWord("are");
		trie.addWord("ant");
		trie.addWord("and");
		trie.addWord("an");
		trie.addWord("as");
		trie.addWord("ask");
		trie.addWord("see");
		trie.addWord("seen");
		trie.addWord("sea");
		
		System.out.println(trie.searchWord("are"));
		
		trie.displayAllWords();
		trie.displayAsTree();
		trie.removeWord("ask");
		trie.displayAsTree();
		trie.removeWord("as");
		trie.displayAsTree();
	}

}
