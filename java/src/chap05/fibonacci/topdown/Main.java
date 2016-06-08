package chap05.fibonacci.topdown;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (memo[n] != -1) { return memo[n]; }
        if (n < 2) { return 1; }
        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
