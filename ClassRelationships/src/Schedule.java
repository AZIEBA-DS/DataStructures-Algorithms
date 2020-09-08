package ClassRelationships;

import java.util.ArrayList;

public class Schedule {
	private ArrayList<Course> m_courses;
	
	public Schedule() {
		m_courses = new ArrayList<Course>();
	}
	
	public void addCourse(Course c) {
		m_courses.add(c);
	}
	
	@Override
	public String toString() {
		return " Your Schedule\n " + m_courses.toString()
		 .replace("[","").replace("]","").replace(",","");
	}
}
