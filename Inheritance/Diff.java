package Inheritance;

public class Diff extends Sum {
	
	public Diff(int op1, int op2) {
		super(op1, op2);
	}
	
	public int operate() {
		return this.getOperand1() - this.getOperand2();
	}
}
