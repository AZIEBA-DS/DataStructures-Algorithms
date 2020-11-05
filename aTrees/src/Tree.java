package aTrees;

public class Tree implements Comparable<Tree> {
	private Tree m_left;
	private Tree m_right;
	private Tree m_parent;
	private char m_char;
	private int m_total;

	public Tree(Tree l, Tree r, char ch, int total) {
		m_left = l;
		m_right = r;
		m_char = ch;
		m_total = total;
	}

	public Tree(char ch, int total) {
		m_char = ch;
		m_total = total;
	}

	public Tree(int total) {
		m_total = total;
	}

	public Tree() {
	}

	public Tree getLeft() {
		return m_left;
	}

	public Tree getRight() {
		return m_right;
	}

	public Tree getParent() {
		return m_parent;
	}

	public void setParent(Tree n) {
		m_parent = n;
	}

	public int getTotal() {
		return m_total;
	}

	public char getChar() {
		return m_char;
	}

	public void setLeft(Tree n) {
		m_left = n;
	}

	public void setRight(Tree n) {
		m_right = n;
	}

	public void printTree() {
		_printTree(this);
	}

	public void _printTree(Tree n) {
		if (n == null) {
			return;
		}

		System.out.println(n.getChar());
		_printTree(n.getLeft());
		_printTree(n.getRight());
	}

	@Override
	public String toString() {
		return String.format("%s (%2d)", m_char, m_total);
	}

	@Override
	public int compareTo(Tree t2) {
		if (getTotal() < t2.getTotal()) {
			return -1;
		} else if (getTotal() > t2.getTotal()) {
			return -1;
		} else {
			return 0;
		}
	}
}