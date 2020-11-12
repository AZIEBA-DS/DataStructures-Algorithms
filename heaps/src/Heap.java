package heaps;

import java.util.*;

class heapNode {
	private int m_data;

	public heapNode(int data) {
		m_data = data;
	}

	public int getData() {
		return m_data;
	}

	public void setData(int id) {
		m_data = id;
	}
}

public class Heap implements IHeap {
	private heapNode[] m_heap;
	private int m_max;
	private int m_current;

	public Heap(int max) {
		m_max = max;
		m_current = 0;
		m_heap = new heapNode[m_max];
	}

	@Override
	public void insert(int item) {
		if (m_current == m_max) {
			System.out.println("Heap is full.");
		} else {
			heapNode newHeap = new heapNode(item);
			m_heap[m_current] = newHeap;
			moveUp(m_current++);
		}
	}

	private void moveUp(int nodeIndex) {
		int parent = getParent(nodeIndex);
		heapNode bottom = m_heap[nodeIndex];

		while (nodeIndex > 0 && m_heap[parent].getData() < bottom.getData()) {
			m_heap[nodeIndex] = m_heap[parent];
			nodeIndex = parent;
			parent = (parent - 1) / 2;
		}
		m_heap[nodeIndex] = bottom;
	}

	@Override
	public void insertAll(List<Integer> items) {
		for (int i = 0; i < items.size(); i++) {
			heapNode insert = new heapNode(items.get(i));
			m_heap[i] = insert;
			moveUp(m_current++);
		}
	}

	@Override
	public int size() {
		return m_current;
	}

	@Override
	public void clear() {
	}

	@Override
	public heapNode removeTop() {
		heapNode root = m_heap[0];
		m_heap[0] = m_heap[--m_current];
		moveDown(0);
		return root;
	}

	private void moveDown(int nodeIndex) {
		int child;

		heapNode top = m_heap[nodeIndex];
		while (nodeIndex < m_current / 2) {
			int leftChild = getLeft(nodeIndex, m_heap);
			int rightChild = getRight(nodeIndex, m_heap);

			if (rightChild < m_current && m_heap[leftChild].getData() < m_heap[rightChild].getData()) {
				child = rightChild;
			} else {
				child = leftChild;
			}

			if (top.getData() >= m_heap[child].getData()) {
				break;
			}

			m_heap[nodeIndex] = m_heap[child];
			nodeIndex = child;
		}
		m_heap[nodeIndex] = top;
	}

	@Override
	public String toString() {
		System.out.print("Backing Array: ");
		for (int i = 0; i < m_current; i++) {
			if (i == m_current - 1) {
				System.out.print(m_heap[i].getData());
			} else {
				System.out.print(m_heap[i].getData() + " -> ");
			}
		}
		System.out.println();
		return "";
	}

	private int getParent(int nodeIndex) {
		return nodeIndex / 2;
	}

	private int getLeft(int nodeIndex, heapNode ary[]) {
		return nodeIndex * 2;
	}

	private int getRight(int nodeIndex, heapNode ary[]) {
		return nodeIndex * 2 + 1;
	}

}
