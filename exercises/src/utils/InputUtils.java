package utils;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class InputUtils {
	private InputUtils() {
	}
	
	public static Scanner sc = new Scanner(System.in);
	
	public static <T> T getInputWithMaxTries(String prompt, Predicate<String> condition, Function<String, T> mapper, int maxTries) {
	    String text = "";
	    int attempts = 0;
	    
	    do {
	        String suffix = attempts > 0 ? "! You have " + (maxTries - attempts) + " attempts left: " : ": ";
	        System.out.print(prompt + suffix);
	        text = sc.nextLine().trim();
	        
	        if (condition.test(text)) {
	            return mapper.apply(text);
	        }
	        
	        attempts++;
	        
	        if (attempts == maxTries) {
	            System.out.println("Maximum attempts exceeded. Please try again later.");
	            System.exit(0);
	        }
	    } while (true);
	}
	
	public static int checkInput(String prefix) {
		String text = "";

		do {
			System.out.print(prefix);
			text = sc.nextLine();
			if (text.matches("\\d+")) {
				break;
			}
		} while (true);

		return Integer.parseInt(text);
	}
}