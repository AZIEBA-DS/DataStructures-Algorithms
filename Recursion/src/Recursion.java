package recursion;

public class Recursion {
	
	public int power(int n, int p) {
		if (p == 0) {
			return 1;
		} else {
			return n * power(n, p-1);		
		}
	}
	
	public int f(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		
		else {
			return f(n - 1) + f(n - 2);
		}
	}
}
