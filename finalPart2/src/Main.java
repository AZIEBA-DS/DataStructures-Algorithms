package finalPart2;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		Huffman h = new Huffman();

		try {

			h.buildTreeFromFile("tree.txt");
			h.buildHashMap();
			h.printTree();

			System.out.println("Encode: " + h.encode("ADDZ"));
			System.out.println("Decode: " + h.decode("0001011"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
