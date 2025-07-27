package org.example;

import java.util.Arrays;

public class LongestCommonSubsequence {


    public static void main(String[] args) {
        String s1 = "AGGTAB";


        String s2 = "GXTXAYB";

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];



        // GTAB  4
        System.out.println("Length of LCS is " + lcs(s1, s2, s1.length(), s2.length(), dp));
        System.out.println(Arrays.deepToString(dp));
    }

    private static int lcs(String s1, String s2, int n, int m, int[][] dp) {


        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        if (n == 0 || m == 0) {
            dp[n][m] = 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        } else {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                dp[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, dp);
            } else {
                dp[n][m] = Math.max(lcs(s1, s2, n - 1, m, dp), lcs(s1, s2, n, m - 1, dp));
            }
        }



        return dp[n][m];

    }
}
