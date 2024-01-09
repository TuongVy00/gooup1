package view;

/*
 * Tìm số tự nhiên hợp lệ lớn nhất trong chuỗi. Biết rằng chuỗi chỉ gồm
các ký tự số và chữ cái không dấu. Ví dụ
 12abu02muzk586cyx  586
 Uyk892nn1234uxo2  1234
 */

public class sotunhienhople {
	public static void main(String[] args) {
		// 12abu02muzk586cyx --> 12 2 586 
		// Uyk892nn1234uxo2aaa  --> 892 1234 2
		String[] tests = {"", "abc", "sdfg6hjk", "123", "Uyk892nn1234uxo2", "12abu02muzk586cyx"};
		for(String test: tests) {
			System.out.println("Max valid number in '" + test + "' --> " + findMaxValidNumber(test) );
		}
	}
	// 1st way
	private static int findMaxValidNumber(String s) {
		int count = 0;
		String[] tokens = s.split("[a-zA-Z]+");
		int max = Integer.MIN_VALUE;
		for (String token: tokens) {
			if (!token.isEmpty()) {
				Integer validNumber = Integer.parseInt(token);
				if (validNumber > max) {
					max = validNumber;
				}
				count++;
			}
		}
		if (count == 0) {
			System.out.println("LOG >>> '" + s + "' need at least one digit ...");
			return 0;
		}
		return max;
	}

}
