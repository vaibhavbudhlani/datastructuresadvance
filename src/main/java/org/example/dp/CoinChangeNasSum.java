package org.example.dp;

import java.util.Arrays;

public class CoinChangeNasSum {
    public static void main(String[] args) {
        int n = 5;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(countWays(n - 1, n, dp));

    }

    private static int countWays(int n, int sum, int[][] dp) {
//        if (sum == 0) {
//            return 1;
//        }
//        if (sum < 0 || n <= 0) {
//            return 0;
//        }
//        if (dp[n][sum] != -1) {
//            return dp[n][sum];
//        }
//        dp[n][sum] = countWays( n - 1, sum) + countWays(coins, n, sum - coins[n - 1]);
//        return dp[n][sum];
        return 1;
    }
}
