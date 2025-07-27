package org.example.dp;

import java.util.Arrays;

// Need to get maximum cuts from given values
// For example 5 is length of rod and you can make cut of size 1 , 2 , 3 SO we can make max 5 cuts of size 1
// or 2 + 1 + 1 + 1 = 4 or 3 + 2 = 2 or 3 + 1 + 1 = 3 or 2 + 2 + 1 = 3
public class MaximumCuts {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c= 3;
        int n = 5;
        int[] dp = new int[n+1];

        System.out.println(getMaximum( a ,b, c , n,dp));
    }

    private static int getMaximum(int a, int b, int c, int n, int[] dp) {

        dp[0] = 0;
        for (int i = 1; i <=n; i++) {
            if (i - a > 0) dp[i] = Math.max(dp[i], dp[i - a]);
            if (i - b > 0) dp[i] = Math.max(dp[i], dp[i - b]);
            if (i - c > 0) dp[i] = Math.max(dp[i], dp[i - c]);
            if (dp[i] != -1) {
                dp[i]++;
            }
        }
        return dp[n];

    }
}
