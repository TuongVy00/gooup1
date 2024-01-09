package view;

import java.util.Scanner;

public class hoanvicuachuoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input: ");
		String str = sc.nextLine();
		System.out.println("Output: ");
		permutation("", str);
	}
	
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.print(prefix + ", ");
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}

}
