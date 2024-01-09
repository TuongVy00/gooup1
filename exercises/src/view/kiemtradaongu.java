package view;

import java.util.Arrays;

/**
 * Kiểm tra 2 chuỗi Strings có phải là đảo ngữ (anagram) của nhau không
   2 Strings được gọi là đảo ngữ nếu chúng sử dụng chung các kí tự, không quan tâm các
   kí tự trống, không phân biệt hoa thường. Mỗi kí tự phải có cùng số lượng trong cả 2 Strings.
   VD: Word -> orWd -> true
 */

public class kiemtradaongu {
	public static void main(String[] args) {
		String s1 = "   W o  rd  ";
		String s2 = " or W    d ";

		String result = areAnagrams(s1, s2) ? " are anagrams!" : " are not anagrams!";
		System.out.println("Anagram or not? --> '" + s1 + "' & '" + s2 + "'" + result);
	}

	public static boolean areAnagrams(String s1, String s2) {
		String normalizedStr1 = normalizeString(s1);
		String normalizedStr2 = normalizeString(s2);

		if (normalizedStr1.length() != normalizedStr2.length()) {
			return false;
		}

		char[] c1 = normalizedStr1.toCharArray();
		char[] c2 = normalizedStr2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);
	}

	public static String normalizeString(String s) {
		return s.toLowerCase().replaceAll("\\s+", "").trim();
	}
}