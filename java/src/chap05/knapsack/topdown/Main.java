package chap05.knapsack.topdown;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, w;
    static int[] value, weight;
    static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();

        value = new int[n];
        weight = new int[n];
        memo = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        for (int[] mv : memo) {
            Arrays.fill(mv, -1);
        }
        System.out.println(dp(n - 1, w));
    }

    public static int dp(int k, int w) {
        if (w < 0) { return Integer.MIN_VALUE; }
        if (k == -1) { return 0; }
        if (memo[k][w] != -1) { return memo[k][w]; }
        memo[k][w] = Math.max(
                dp(k - 1, w - weight[k]) + value[k],
                dp(k - 1, w));
        return memo[k][w];
    }
}
