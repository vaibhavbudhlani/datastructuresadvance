package org.example.dp;

import java.util.Arrays;

public class MaximumCutsMemoization {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(getMaximum(a, b, c, n, dp));
    }

    private static int getMaximum(int a, int b, int c, int n, int[] dp) {
        if (n == 0) return 0;
        if (n < 0) return -1;
        if (dp[n] != -1) {
            System.out.println("Coming inside this ");
            return dp[n];
        }

        int resA = getMaximum(a, b, c, n - a, dp);
        int resB = getMaximum(a, b, c, n - b, dp);
        int resC = getMaximum(a, b, c, n - c, dp);

        int maxCuts = Math.max(resA, Math.max(resB, resC));
        dp[n] = (maxCuts == -1) ? -1 : maxCuts +1 ;

        return dp[n];
    }
}