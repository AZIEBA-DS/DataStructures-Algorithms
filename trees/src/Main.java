package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String args[]) {
		
		BinaryTree<String> treeD = new BinaryTree<String>("D");
		BinaryTree<String> treeE = new BinaryTree<String>("E");
		BinaryTree<String> treeF = new BinaryTree<String>("F");
		BinaryTree<String> treeB = new BinaryTree<String>("B", treeD, treeE);
		BinaryTree<String> treeC = new BinaryTree<String>("C", null, treeF);
		BinaryTree<String> root = new BinaryTree<String>("A", treeB, treeC);

		// D B E A C F
		String s = root.toString();
		System.out.println(s);

		List<BinaryTree<String>> trees = new ArrayList<BinaryTree<String>>();
		trees.add(treeD);
		trees.add(treeF);
		trees.add(treeC);
		trees.add(treeE);
		trees.add(root);
		trees.add(treeB);

		Collections.sort(trees);
		
		// A B C D E F
		
		for (BinaryTree<String> t : trees) {
			System.out.println();
			System.out.print(t.getValue() + " ");
			System.out.println();
		}
	}
}
