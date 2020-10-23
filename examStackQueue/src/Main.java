package examStackQueue;

public class Main {
	public static void main(String[] args) {
		MinStack<Integer> stack = new MinStack<Integer>();

		stack.push(4);
		System.out.println("Current Min: " + stack.min());
		System.out.println(stack.toString());
		
		stack.push(5);
		System.out.println("Current Min: " + stack.min());
		System.out.println(stack.toString());
		
		stack.push(6);
		System.out.println("Current Min: " + stack.min());
		System.out.println(stack.toString());
		
		stack.push(3);
		System.out.println("Current Min: " + stack.min());
		System.out.println(stack.toString());
		
		stack.push(1);
		stack.push(1);
		System.out.println("Current Min: " + stack.min());
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println("Current Min: " + stack.min());
		
		System.out.println(stack.toString());
	}
}
