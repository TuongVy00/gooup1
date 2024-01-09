package view;

/*
 * Viết hàm kiểm tra một số có phải là số đặc biệt không. Biết rằng nếu
tổng tất cả các số nguyên từ 1 đến n bằng S thì S là số đặc biệt. Ví dụ
 1 -> 1
 3 -> 1 + 2
 6 -> 1 + 2 + 3
 10 -> 1 + 2 + 3 + 4
 */

public class sodacbiet {
	
	public static void main(String[] args) {
		int[] tests = { 1, 3, 6, 10, 12, 15 };
		for (int test : tests) {
			System.out.println("is special " + test + " --> " + isSpecial(test));
		}
	}

	private static boolean isSpecial(int n) {
		int running = 1;
		int sum = 0;
		while (sum < n) {
			sum += running;
			running++;
		}
		return sum == n;
	}

}
