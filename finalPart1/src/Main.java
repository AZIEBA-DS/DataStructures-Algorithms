package finalPart1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers1 = new ArrayList<Integer>();
		
		numbers1.add(6);
		numbers1.add(5);
		numbers1.add(9);
		numbers1.add(2);
		
		System.out.println("Original List: " + numbers1);
		HeapSort.sort(numbers1);
		System.out.println("Sorted List: " + numbers1);
		System.out.println();
		
		List<Integer> numbers2 = new ArrayList<Integer>();
		
		numbers2.add(100);
		numbers2.add(90);
		numbers2.add(80);
		numbers2.add(70);
		numbers2.add(60);
		numbers2.add(50);
		numbers2.add(40);
		numbers2.add(30);
		numbers2.add(20);
		numbers2.add(10);
		
		
		System.out.println("Orignal List: " + numbers2);
		HeapSort.sort(numbers2);
		System.out.println("Sorted List: " + numbers2);

	}
}
