package view;

import java.util.Arrays;

/**
 * Cho mảng A gồm n phần tử (2 < n < 20). Ak = [0, 100]
 * Viết hàm liệt kê các phần tử chỉ xuất hiện một lần duy nhất trong mảng.
 *  Kết quả trả về được sắp xếp tăng dần.
 * Input: 3, 15, 21, 0, 15, 17, 21
 * Output: 0, 3, 17
 * Method signature: int[] getUniqueNumbers(....)
 */

public class UniqueNumber {
	public static void main(String[] args) {
		int[] numbers = { 3, 15, 21, 0, 15, 17, 21 };
		System.out.println("Unique number is --> " + Arrays.toString(getUniqueNumbers(numbers)));
	}

	private static int[] getUniqueNumbers(int[] numbers) {
		int length = numbers.length;
		boolean[] flags = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (flags[i])
				continue;
			for (int j = 0; j < length; j++) {
				if (i != j && numbers[i] == numbers[j]) {
					flags[i] = true;
					flags[j] = true;
				}
			}
		}
		int[] result = new int[length];
		int index = 0;
		for (int j = 0; j < flags.length; j++) {
			if (!flags[j]) {
				result[index++] = numbers[j];
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

}