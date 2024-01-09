package view;

import java.util.Arrays;

/**
 * Cho mảng A gồm n-1 phần tử không trùng nhau, giá trị của mỗi phần
 * tử trong mảng, Ak = [1, n].
 * Tìm số nguyên còn lại trong khoảng [1, n] không tồn tại trong mảng A.
 * VD1: n = 6, Ak = [3, 2, 1, 6, 5]
 * Phần tử cần tìm có giá trị: 4
 * VD2: n = 10, Ak = [3, 7, 9, 2, 1, 6, 5, 4, 10]
 * Phần tử cần tìm có giá trị: 8
 * Method signature: int getMissingNumber(...)
 */

public class MissingNumber {
	public static void main(String[] args) {
		int[] numbers = { 3, 7, 9, 2, 1, 6, 5, 4, 10 };
		System.out.println("Missing number is --> " + getMissingNumber(numbers));

	}

	private static int getMissingNumber(int[] numbers) {
		// Step 1: Find maximum number
		int n = numbers.length + 1;

		// Step 2: Calculate sum of array which contains all elements [1-10]
		int sum = n * (n + 1) / 2;

		// Step 3: Calculate sum of array which have a missing element
		int sumOfElement = 0;
		for (int number : numbers) {
			sumOfElement += number;
		}
		return sum - sumOfElement;
	}
	
//	public static void main(String[] args) {
//	    int[] numbers = { 9, 2, 1, 6, 5, 4, 10 };
//	    int n = numbers.length + 1; // Số phần tử trong mảng đã cho + 1
//	    printMissingNumbers(numbers, n);
//	}
//
//	private static void printMissingNumbers(int[] numbers, int n) {
//	    int missingCount = 0;
//	    StringBuilder missingElements = new StringBuilder();
//
//	    // Step 1: Calculate sum of first n natural numbers
//	    int sum = n * (n + 1) / 2;
//
//	    // Step 2: Calculate sum of array which have a missing element
//	    int sumOfElements = 0;
//	    for (int number : numbers) {
//	        sumOfElements += number;
//	    }
//
//	    // Step 3: Find and build missing elements string
//	    for (int i = 1; i <= n; i++) {
//	        if (!contains(numbers, i)) {
//	            if (missingCount > 0) {
//	                missingElements.append(", ");
//	            }
//	            missingElements.append(i);
//	            missingCount++;
//	        }
//	    }
//
//	    // Step 4: Print the result
//	    if (missingCount == 1) {
//	        System.out.println("Phần tử cần tìm có giá trị: " + missingElements.toString());
//	    } else if (missingCount > 1) {
//	        System.out.println("Phần tử cần tìm có giá trị: " + missingElements.toString());
//	    } else {
//	        System.out.println("Không có phần tử nào bị thiếu trong khoảng từ 1 đến " + n);
//	    }
//	}
//
//	private static boolean contains(int[] arr, int num) {
//	    for (int element : arr) {
//	        if (element == num) {
//	            return true;
//	        }
//	    }
//	    return false;
//	}
}
