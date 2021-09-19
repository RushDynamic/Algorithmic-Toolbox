import java.util.*;
import java.util.Random;

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
		// stressTest(15, 20);
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

	private static long calculateMaxProductBruteforce(long[] numbers) {
		long max = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				long product = numbers[i] * numbers[j];
				max = product > max ? product : max;
			}
		}
		return max;
	}

	private static void stressTest(int maxElements, int maxValue) {
		Random random = new Random();
		while (true) {
			int n = random.nextInt(maxElements);
			long[] numbers = new long[n];
			for (int i = 0; i < n; i++) {
				int value = random.nextInt(maxValue);
				System.out.println(value);
				numbers[i] = value;
			}
			System.out.println(Arrays.toString(numbers));
			if (calculateMaxProductBruteforce(numbers) != calculateMaxProduct(numbers)) {
				System.out.println("FAIL: " + Arrays.toString(numbers));
				break;
			}
		}
	}
}