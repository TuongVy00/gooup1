package view;

/**
 * Cho n xâu chuỗi, mỗi chuỗi bao gồm các ký tự la tinh thường và chữ số. 
 * Đoạn các ký tự số liên tục tạo thành một số nguyên. 
 * Ở mỗi xâu chuỗi trích ra các số nguyên và tìm số lớn nhất, 
 * sắp xếp các số lớn nhất nhận được từ các xâu đã cho và in ra theo thứ tự không giảm, 
 * mỗi số được đưa ra dưới dạng không có các số 0 không có nghĩa (024)
 * Nếu chuỗi rỗng hoặc chuỗi chỉ chứa các ký tự latinh thì số lớn nhất của chuỗi đó là 0
 * Ví dụ: với n = 1 : xâu 01a2b3456cde478 ---> Kết quả: 3456
 *        với n = 2 : xâu aa6b546c6e22h, aa6b326c6e22h --> Kết quả: 326, 546
 * Method signature: getLargestNumbers(String ...ss) >> String[]
 */

public class LargestNumbers {
	public static void main(String[] args) {
		String s1 = "01a2b3456cde478";
		String s2 = "aa6b546c6e22h";
		String s3 = "aa6b326c6e22h";
		String s4 = "";
		String s5 = "abckdjfkjadfka";
		String[] digits = getLargestNumbers(s1, s2, s3, s4, s5);

		System.out.print("Largest numbers in ascending order --> ");
		for (String digit : digits) {
			System.out.print(digit + " ");
		}
	}

	private static int findMaxNumber(String input) {
		if (input.isEmpty() || input.matches("[a-zA-Z]+")) {
			return 0;
		}

		String[] tokens = input.split("[a-zA-Z]+");
		int counter = 0;
		int max = Integer.MIN_VALUE;
		for (String token : tokens) {
			if (!token.isEmpty()) {
				Integer validNumber = Integer.parseInt(token);
				if (validNumber > max) {
					max = validNumber;
				}
			}
			counter++;
		}
		return max;
	}

	// sorting in ascending order
	private static void sort(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	private static String[] getLargestNumbers(String... ss) {
		int[] numbers = new int[ss.length];
		int counter = 0;
		for (String s : ss) {
			numbers[counter++] = findMaxNumber(s);
		}

		sort(numbers);

		String[] result = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			result[i] = "" + numbers[i];
		}
		return result;
	}
}