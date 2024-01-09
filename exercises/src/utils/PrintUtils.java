package utils;

public class PrintUtils {
	private PrintUtils() {
	}

	public static <T> void print(String prefix, Iterable<T> elements) {
		System.out.println("\n" + prefix);
		System.out.println("===__--------------------__===");
		elements.forEach(System.out::println);
		System.out.println("===__--------------------__===\n");
	}
}