package ExamHeaps;

import java.util.*;
import java.util.Scanner;

public class ExamHeaps {

	public static void main(String[] args) {
		ExamHeaps main = new ExamHeaps();
		main.go();
	}

	public void go() {
		int ary[] = { 82, 79, 46, 16, 12, 39, 41, 6, 4, 11 };

		int root = getRoot(ary);
		System.out.printf("Root: %s%n", root);

		List leaves = getAllLeaves(ary);
		System.out.printf("Leaves: %s%n", leaves);

		List parents = getAllParents(ary);
		System.out.printf("Parents: %s%n", parents);

		boolean isMaxHeap1 = isMaxHeap(0, ary);
		System.out.printf("Is MaxHeap: %s%n", isMaxHeap1);
	}

	// ---------------------------------------------------------------
	// return the value of the root of the tree represented by ary
	// ---------------------------------------------------------------
	public int getRoot(int ary[]) {
		return ary[0];
	}

	// ---------------------------------------------------------------
	// return a list containing the values for all of the nodes in the
	// tree that are leaves
	// ---------------------------------------------------------------
	public List getAllLeaves(int ary[]) {
		List l = new ArrayList();

		for (int i = 0; i < ary.length; i++) {
			if ((2 * i + 1) > ary.length && (2 * i + 2) > ary.length) {
				l.add(ary[i]);
			}
		}

		return l;
	}

	// ---------------------------------------------------------------
	// return a list containing the values for all of the nodes in the
	// tree that are parents
	// ---------------------------------------------------------------
	public List getAllParents(int ary[]) {
		List l = new ArrayList();

		for (int i = 0; i < ary.length; i++) {
			if ((2 * i + 1) <= ary.length || (2 * i + 2) <= ary.length) {
				l.add(ary[i]);
			}
		}

		return l;
	}

	// ---------------------------------------------------------------
	// return true if the tree represented by ary is a valid max heap
	// ---------------------------------------------------------------
	public boolean isMaxHeap(int rootIndex, int ary[]) {

		for (int i = 0; i < ary.length; i++) {
			if (ary[i] > ary[rootIndex]) {
				return false;
			}
		}
		return true;
	}
}
