package view;

/**
 * Cho mảng A gồm n phần tử (2 < n < 20). Ak = [1, 10]
 * Tìm bội chung nhỏ nhất của các phần tử trong mảng
 * VD1: Ak = [2, 3] >> BCNN = 6
 * VD2: Ak = [2, 3, 4] >> BCNN = 12
 * Method signature: int getLeastCommonMultiple(....)
 * UCLN: Greatest common divisor (GCD)
 * BCNN: Least common multiple (LCM)
 */

public class LeastCommonMultiple {
	public static void main(String[] args) {
		int[] numbers = { 2, 3, 4 };
		System.out.println("Least common multiple is --> " + getLeastCommonMultiple(numbers));
	}

	// Find GCD of two numbers
	private static int findGCD(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}

	// From GCD --> find LCM of two numbers
	private static int findLCM(int a, int b) {
		return a * b / findGCD(a, b);
	}

	// From GCD LCM of two numbers --> find LCM of an array
	private static int getLeastCommonMultiple(int[] numbers) {
		int length = numbers.length;

		if (length == 0) {
			System.out.println("At least one element is required!!!");
			return Integer.MIN_VALUE;
		}

		if (length == 1) {
			System.out.println("This array has only one element!!!");
			return numbers[0];
		}

		int result = findLCM(numbers[0], numbers[1]);
		for (int i = 2; i < length; i++) {
			result = findLCM(result, numbers[i]);
		}
		return result;
	}

}