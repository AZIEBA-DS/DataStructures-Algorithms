package sorting2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingMain {
	public static void main(String[] args) {
		
		Person m_p1 = new Person("Bob", 35);
		Person m_p2 = new Person("John", 23);
		Person m_p3 = new Person("Adam", 27);
		Person m_p4 = new Person("Ryan", 21);
		
		List<Person> people = new ArrayList<Person>();
		people.add(m_p1);
		people.add(m_p2);
		people.add(m_p3);
		people.add(m_p4);
		
		// Uses natural ordering from Person class to sort in descending order by age.
		Collections.sort(people);
		System.out.println("People sorted by age in descending order: " + people);
		
		// Uses custom ordering to sort in ascending order by age.
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				if (p1.getAge() > p2.getAge())
					return 1;
				else if (p1.getAge() < p2.getAge())
					return -1;
				else
					return 0;
			}
		});
		System.out.println("People sorted by age in ascending order: " + people);
	}
}
