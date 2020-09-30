package aRecursion;

public class CombinationRecursion {
	private int count;
	public int calculate(double n, double k) {
		if (n == 0 || k == 0 || k == n) return 1;
		else {
			count = (calculate(n - 1, k - 1) + calculate(n - 1, k));
		}
		return count;
	}
}
