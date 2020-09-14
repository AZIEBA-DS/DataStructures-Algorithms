package sorting2;

public class Person implements Comparable<Person> {
	
	private String m_name;
	private int m_age;
	
	public Person(String name, int age) {
		m_name = name;
		m_age = age;
	}
	
	public String getName() {
		return m_name;
	}
	
	public int getAge() {
		return m_age;
	}
	
	public void setName(String name) {
		m_name = name;
	}
	
	public void setAge(int age) {
		m_age = age;
	}
	
	@Override
	public int compareTo(Person other) {
		return ~(Integer.compare(this.getAge(), other.getAge()));
	}
	
	@Override
	public String toString() {
		String s = String.format("%s (%s)", m_name, m_age);
		return s; 
	}
	
}

