package view;

/**
 * Viết chương trình nhập vào 1 số thực có phần thập phân khác 0. 
 * Yêu cầu nhập lại nếu nhập sai. 
 * Nếu số lần nhập sai vượt quá 3 lần => thông báo lỗi và kết thúc chương trình
 * Nếu nhập đúng yêu cầu => tìm phân số tối giản của số thập phân đó. 
 * Ví dụ
 * 0.1 => 1/10
 * 0.2 => 1/10
 * 0.04 => 1/25
 * 0.75 => 2/3
 * 1.5 => 3/2 
 * 
 * numerator: tử số 
 * denominator: mẫu số 
 * gcd: ước chung lớn nhất
 */

import static utils.InputUtils.*;

import java.math.BigInteger;

public class sothapphankhac0 {
	public static void main(String[] args) {
		double input = getInputWithMaxTries("Enter a real number with a non-zero decimal part",
				sothapphankhac0::hasNonZeroDecimalPart, Double::parseDouble, 3);

		reduceDecimalToFraction(input);
	}

	private static boolean hasNonZeroDecimalPart(String number) {
		double parsedNumber = Double.parseDouble(number);
		int integerPart = (int) parsedNumber;
		double decimalPart = parsedNumber - integerPart;
		return decimalPart != 0;
	}

	private static void reduceDecimalToFraction(double number) {
		BigInteger numerator = BigInteger.valueOf((int) (number * 100));
		BigInteger denominator = BigInteger.valueOf(100);
		BigInteger gcd = numerator.gcd(denominator);

		numerator = numerator.divide(gcd);
		denominator = denominator.divide(gcd);

		System.out.println("The simplified fraction of " + number + " is: " + numerator + "/" + denominator);
	}
}