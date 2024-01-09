package view;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Viết chương trình thực hiện chức năng đăng ký tài khoản
 * B1. Nhập tên tài khoản ví dụ byztkhx256
 * B2. Nhập mật khẩu admin123
 * Yêu cầu mật khẩu như sau:
 * 1. Độ dài mật khẩu: >= 8
 * 2. Có ít nhất 1 chữ số, 1 kí tự in hoa, và một kí tự đặc biệt (~!@#$%^&*)
 * 3. Không được trùng quá 3 ký tự với tên tài khoản [Đăng ký khi bắt đầu chương trình]
 * Sau khi đã thỏa mãn yêu cầu thông báo đăng ký tài khoản thành công
 */

public class RegisterAccount {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Please enter username: ");
		String username = sc.nextLine();
		String password = "";
		do {
			try {
				System.out.print("Please enter password: ");
				password = sc.nextLine();
				if (isValid(password, username) && isDuplicateLessThanNLetters(password, username, 3)) {
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (true);

		System.out.println("Thanks! Your account has been successfully signed up.");
	}

	private static boolean isValid(String password, String username) throws Exception {
		if (password.length() < 8) {
			throw new Exception("Password must contain at least 8 character!!!");
		}
		if (!Pattern.matches(".*[0-9].*", password)) {
			throw new Exception("Password must contain at least 1 number (1, 2, 3, ...)!!!");
		}
		if (!Pattern.matches(".*[A-Z].*", password)) {
			throw new Exception("Password must contain at least 1 uppercase aphabetic character (A,B,C,..)");
		}
		if (!Pattern.matches(".*[^a-zA-Z0-9].*", password)) {
			throw new Exception("Password must contain at least 1 special character (~!@#$%^&*]+)!!!");
		}
		if (!isDuplicateLessThanNLetters(password, username, 3)) {
			throw new Exception("Password can't duplicate more than 3 characters with the account name!!!");
		}
		return true;
	}

	private static boolean isDuplicateLessThanNLetters(String password, String username, int n) {
		int isExistedLetter = 0;
		for (int i = 0; i < password.length(); i++) {
			String letter = "" + password.charAt(i);
			if (username.contains(letter)) {
				isExistedLetter++;
				if (isExistedLetter == n) {
					return false;
				}
			}
		}
		return true;
	}
}