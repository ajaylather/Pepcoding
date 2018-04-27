package apr15_Priority_Queue_and_Huffman_Compresseion;

public class Huffman_client {

	public static void main(String[] args) {

//		Huffman str = new Huffman("aaaaaababababaaabbaaabbddddcccccccdddddddddccaaaabaeeeeeffffffggggg");
//		System.out.println(str.encode("abbccddeeffg"));
//		System.out.println(str.decode("110110111001000000101010100100101011"));
//		
		Huffman str1 = new Huffman("aaaaabbbbbcccccdddddeeeeefffffggggghhhhhiiiii");
		System.out.println(str1.encode("abcdefghi"));
		System.out.println(str1.decode("00010111001111111110010100001"));
	}
}
