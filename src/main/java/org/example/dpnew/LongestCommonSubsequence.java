package org.example.dpnew;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(lcs(s1, s2, dp, s1.length(), s2.length()));
    }

    private static int lcs(String s1, String s2, int[][] dp, int n, int m) {
        if(n==0 || m==0 ){
            return dp[n][m] = 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (dp[n][m] == -1) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                dp[n][m] = 1 + lcs(s1, s2, dp, n - 1, m - 1);
            } else {
                dp[n][m] = Math.max(lcs(s1, s2, dp, n - 1, m), lcs(s1, s2, dp, n, m - 1));
            }
        } else {
            return dp[n][m];
        }

        return 0;
    }
}
