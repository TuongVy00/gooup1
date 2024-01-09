package view;
/*
 * Viết hàm kiểm tra một số có phải là lũy thừa của một số khác không
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class kiemtraluythua {
	public static void main(String[] args) {
		System.out.println("power(2, 8):" + isPowerOf(2, 8));
		System.out.println("power(8, 2):" + isPowerOf(8, 2));
		
		System.out.println("power(3, 9):" + isPowerOf(3, 9));
		System.out.println("power(16, 4):" + isPowerOf(16, 4));
		
		System.out.println("power(4, 64):" + isPowerOf(4, 64));
		System.out.println("power(64, 5):" + isPowerOf(64, 5));
	}

	private static boolean isPowerOf(int a, int b) {
		double log = BigDecimal.valueOf(
						Math.log(Math.max(a, b)) / Math.log(Math.min(a, b))
					 )
				.setScale(6, RoundingMode.HALF_UP)
				.doubleValue();
		return Math.ceil(log) == Math.floor(log);
	}

}
