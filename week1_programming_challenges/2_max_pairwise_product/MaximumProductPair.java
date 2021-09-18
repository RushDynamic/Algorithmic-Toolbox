import java.util.*;

public class MaximumProductPair {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] numbers = new long[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextLong();
		}
		scanner.close();
		System.out.println(calculateMaxProduct(numbers));
	}

	private static long calculateMaxProduct(long[] numbers) {
		long max = 0, nextMax = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				nextMax = max;
				max = numbers[i];
			} else if (numbers[i] > nextMax) {
				nextMax = numbers[i];
			}
		}
		return max * nextMax;
	}
}