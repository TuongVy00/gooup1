package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Cho 2 mảng số nguyên đơn điệu có cùng số phần tử là n (4 < n < 40). Viết phương thức tìm số phần
tử chung của 2 mảng đó
Example
Mảng 1: 2 8 9 1 6
Mảng 2: 2 1 1 8 9
Output
1 2 8 9
 */

public class phantuchung {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr1 = getInputArray(sc, n, "Arr1");
        int[] arr2 = getInputArray(sc, n, "Arr2");

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            set2.add(num);
        }

        set1.retainAll(set2); 
//        set1.removeAll(set2);

        System.out.print("Output: ");
        for (int num : set1) {
            System.out.print(num + " ");
        }
    }

    private static int[] getInputArray(Scanner sc, int n, String arrName) {
        System.out.println(arrName + ": ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

}
