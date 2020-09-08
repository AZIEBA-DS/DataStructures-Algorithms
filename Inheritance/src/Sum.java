package Inheritance;

public class Sum extends IBinaryOperator{
	private int m_op1;
	private int m_op2;
	
	public Sum(int op1, int op2) {
		m_op1 = op1;
		m_op2 = op2;
	}
	
	public void setOperand1(int o1) {
		m_op1 = o1;
	}
	public void setOperand2(int o2) {
		m_op2 = o2;
	}
	
	public int getOperand1() {
		return m_op1;
	}
	public int getOperand2() {
		return m_op2;
	}
	
	public int operate() {
		return this.getOperand1() + this.getOperand2();
	}
}
