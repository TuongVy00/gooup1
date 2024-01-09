package view;

/**
 * Cho dãy kí tự chứa các kí tự thường và khoảng trắng.
 * Viết chương trình loại bỏ khoảng trắng thừa và đảo chuỗi như sau:
 * Example: input: Welcome to JAVA10 class
 * output: emocleW ot 01AVAJ ssalc
 * Method signature: revert(String s) >> String
 */

public class Reversing {
	public static void main(String[] args) {
		String input = "  Welcome    to   JAVA10  class   ";
		
		StringBuilder sb = new StringBuilder();
		String[] words = input.trim().split("\\s+");
		for (String word : words) {
			sb.append(reverse(word)).append(" ");
		}
		System.out.println("Result --> " + sb.toString().trim());
	}
	
	private static String reverse(String string) {
		return new StringBuilder(string).reverse().toString();
	}
}