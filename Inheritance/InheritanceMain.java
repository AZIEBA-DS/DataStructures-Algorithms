package Inheritance;

public class InheritanceMain {
	public static void main(String[] args) {
		
		IBinaryOperator s = new Diff(8, 12);
		System.out.println(s.operate()); // should print 20
		s.setOperand1(18);
		System.out.println(s.operate()); // should print 30
		
	}
}
