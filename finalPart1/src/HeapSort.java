package finalPart1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort extends Heap<Integer> {
	public static void sort(List<Integer> items) {
		List<Integer> sortedList = new ArrayList<Integer>();
		Heap<Integer> h = new Heap<Integer>();
		h.insertAll(items);
		
		//Populating new list
		for (int i = items.size() - 1; i >= 0; i--) {
			
			//Remove root, re-heap, and add root to list.
			sortedList.add(h.removeTop());
		}
		
		//Reverse order and clear original list
		Collections.reverse(sortedList);
		items.clear();
		
		//Copying new list to original list
		for (int i = 0; i < sortedList.size(); i++) {
			items.add(sortedList.get(i));
		}
	}

}
