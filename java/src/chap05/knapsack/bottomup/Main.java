package chap05.knapsack.bottomup;

import java.util.Scanner;

public class Main {
    static int n, w;
    static int[] value, weight;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();

        value = new int[n + 1];
        weight = new int[n + 1];
        dp = new int[n + 1][w + 1];
        for (int i = 0; i < n; i++) {
            value[i + 1] = sc.nextInt();
            weight[i + 1] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n][w]);
    }
}
