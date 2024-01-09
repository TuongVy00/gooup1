package view;

import java.util.Arrays;
import java.util.Comparator;

public class levelsotunhien {
	public static void main(String[] args) {
        Integer[] arr = {8, 5, 9, 20};
        Arrays.sort(arr, Comparator.comparingInt(levelsotunhien::countDivisors));
        show(arr);
    }

    private static int countDivisors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    private static void show(Integer[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
