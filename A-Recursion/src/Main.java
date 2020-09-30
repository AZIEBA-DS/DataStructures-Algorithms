package aRecursion;

public class Main {
	public static void main(String[] args) {
		
		// 3. String Recursion ---------------------------------------------------------------------------
		StringRecursion sr = new StringRecursion();
		String s = "this is a string to test the replace method. A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		String s2 = "";
		char c1 = 't';
		char c2 = '_';
		
		System.out.println("Original String: " + s);
		System.out.println("Changed String: " + sr.replace(s, c1, c2));
		System.out.println();
		System.out.println("Original String: " + s2);
		System.out.println("Changed String: " + sr.replace(s2, c1, c2));
		
		// 4. Combination Recursion-----------------------------------------------------------------------
		
		CombinationRecursion cr = new CombinationRecursion();
		double objects = 5;
		double times = 2;
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(cr.calculate(objects, times));
		
		
		
	}
}
