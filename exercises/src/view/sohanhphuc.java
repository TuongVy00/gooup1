package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Một số hạnh phúc được xác định như sau
Với một số nguyên dương bất kì
Thay thế số đó bằng tổng bình phương các chữ số của nó
Và lặp đi lặp lại qúa trình cho đến khi được số bằng 1 hoặc nó lặp vô tận trong một chu kì mà
không bao gồm 1.
Những con số kết thức bằng 1 là những con số hạnh phúc, trường hợp còn lại gọi là số FA
Hãy cùng thử với số 44
Lần 1: 42 + 4
2 = 32
Lần 2: 32 + 2
2 = 13
Lần 3: 12 + 3
2 = 10
Lần 4: 12 + 0
2 = 1

Do đó số 44 là số hạnh phúc
Viết chương trình kiểm tra một số có phải là số hạnh phúc không
 */

public class sohanhphuc {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        int n = sc.nextInt();
        
        if (isHappyNumber(n)) {
            System.out.println(n + " là số hạnh phúc.");
        } else {
            System.out.println(n + " không phải là số hạnh phúc.");
        }
    }

    private static boolean isHappyNumber(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        
        return n == 1;
    }

}
