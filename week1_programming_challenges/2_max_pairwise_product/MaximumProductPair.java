import java.util.*;

public class MaximumProductPair {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(calculateMaxProduct(numbers));
	}

	private static int calculateMaxProduct(int[] numbers) {
		int max = 0, nextMax = 0;
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