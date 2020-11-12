package heaps;

import java.util.List;

public interface IHeap {
	// Adds an item to the heap.
	public void insert(int item);

	// Inserts all the items in the list into
	// the heap.
	public void insertAll(List<Integer> items);

	// Returns the number of items in the heap.
	public int size();

	// Returns and removes the item at the top of the heap.
	// The topmost item will either be the largest or
	// the smallest item in the heap, depending on the
	// the state of the heap (max or min).
	public heapNode removeTop();

	// Removes all items in the heap.
	public void clear();
}
