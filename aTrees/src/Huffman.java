package aTrees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
	public void populateNodesFromFile(String file, List<String> nodes) throws FileNotFoundException {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (br.ready()) {
				nodes.add(br.readLine());
			}
		} catch (IOException e) {
			System.out.println("IOException in populate nodes from file.");
			e.printStackTrace();
		}
	}

	public Tree buildTreeFromNodes(List<String> nodes) {
		String data = nodes.toString();
		PriorityQueue<Tree> queue = new PriorityQueue<Tree>();
		int tempInt = -1;
		char tempChar = ' ';

		for (int i = 0; i < data.length(); i++) {
			if (Character.isDigit(data.charAt(i))) {
				if (Character.isDigit(data.charAt(i + 1))) {
					String tempString = "" + data.charAt(i) + data.charAt(i + 1);
					tempInt = Integer.parseInt(tempString);
				} else if (!Character.isDigit(data.charAt(i - 1))) {
					String tempString = "" + data.charAt(i);
					tempInt = Integer.parseInt(tempString);
				}
			} else if (data.charAt(i) != ',' && data.charAt(i) != '[' && data.charAt(i) != ']'
					&& data.charAt(i) != ' ') {
				tempChar = data.charAt(i);
			}
			if (tempChar != ' ' && tempInt != -1) {
				Tree t = new Tree(tempChar, tempInt);
				queue.add(t);
			}
			tempChar = ' ';
			tempInt = 0;
		}
		Tree root = null;
		while (queue.size() > 1) {
			Tree left = queue.poll();
			Tree right = queue.poll();

			Tree combined = new Tree(left.getTotal() + right.getTotal());
			combined.setLeft(left);
			combined.setRight(right);
			queue.add(combined);

			root = combined;
		}
		return root;
	}

	public void printTree(Tree root) {
		root.printTree();
	}

	public String getCode(Tree root, char ch) {
		String output = "";

		if (root.getLeft() == null && root.getRight() == null) {
			return "null";
		} else if (root.getLeft() != null && root.getRight() == null) {
			output += "0";
		} else if (root.getLeft() == null && root.getRight() != null) {
			output += "1";
		} else {
			if (root.getLeft().compareTo(root.getRight()) == -1) {
				output += "0";
			} else if (root.getLeft().compareTo(root.getRight()) == 0) {
				output += "1";
			} else if (root.getLeft().compareTo(root.getRight()) == -1) {
				output += "1";
			}
		}

		return output;
	}

	public String decode(Tree root, String code) {
		String result = "";
		Tree t = root;
		for (int i = 0; i < code.length(); i++) {
			char ch = code.charAt(i);
			if (ch == '0') {
				t = t.getLeft();
			} else {
				t = t.getRight();
			}
			if (t.getLeft() == null) // n is a leaf
			{
				result = result + t.getChar();
				t = root;
			}
		}
		return result;
	}
}