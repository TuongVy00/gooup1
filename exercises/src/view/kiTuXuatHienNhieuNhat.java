package view;

import java.util.HashMap;
import java.util.Map;

/**
 * Viết chương trình tìm kiếm kí tự có số lần xuất hiện nhiều nhất trong chuỗi.
 * Input: Chuỗi gồm các kí tự [a-zA-Z] 
 * Example: aaaababbbddc => Output: “a”
 * aaaccdcee => Output: “a”, “c”
 */

public class kiTuXuatHienNhieuNhat {
	public static void main(String[] args) {
		String s = "aaaccdcee";
		System.out.println("The most frequent character(s) is/are --> " + findMostFrequentCharacters(s));	
	}

	public static String findMostFrequentCharacters(String s) {
		char[] characters = s.toLowerCase().trim().toCharArray();

		Map<String, Integer> charCount = countChar(characters);

		int max = 0;
		String maxChars = "";

		for (Map.Entry<String, Integer> entry : charCount.entrySet()) {
			int element = entry.getValue();
			if (element > max) {
				max = element;
				maxChars = entry.getKey();
			} else if (element == max) {
				maxChars += ", " + entry.getKey();
			}
		}
		return maxChars;
	}

	private static Map<String, Integer> countChar(char[] characters) {
		Map<String, Integer> map = new HashMap<>();
		for (char c : characters) {
			String key = String.valueOf(c);
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		return map;
	}
}