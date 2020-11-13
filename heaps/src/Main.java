package heaps;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// you can use this method to test your heap
		// you can put any code you like here

		// here is some sample code that creates
		// a heap...
		Integer[] ary = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		List<Integer> l = Arrays.asList(ary);
		Heap h = new Heap(100);
		h.insertAll(l);
		h.toString();

		h.removeTop();
		h.toString();

		h.removeTop();
		System.out.println(h);
		
		h.clear();
		System.out.println(h);
	}
}
