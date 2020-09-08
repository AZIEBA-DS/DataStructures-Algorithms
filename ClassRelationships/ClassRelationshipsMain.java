package ClassRelationships;
public class ClassRelationshipsMain {
	public static void main (String[] args) {
		Schedule schedule = new Schedule();
		
		Course a = new Course("Networking", "8am", "8:50am");
		schedule.addCourse(a);
		
		Course b = new Course("Database", "9am", "9:50am");
		schedule.addCourse(b);
		
		Course c = new Course("Database", "9am", "9:50am");
		schedule.addCourse(c);
		
		Course d = new Course("Database", "9am", "9:50am");
		schedule.addCourse(d);
		
		Course e = new Course("Database", "9am", "9:50am");
		schedule.addCourse(e);
		
		System.out.println(schedule.toString());
	}
	
}