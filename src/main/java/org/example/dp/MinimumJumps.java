package org.example.dp;

import java.util.Arrays;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] a = {3, 4, 2, 1, 2, 1};
        int[] a1 = {4, 1, 5, 3, 1, 3, 2, 1, 8};
        int[] dp = new int[a.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
       // dp[0] = 0;
        System.out.println(minJumps(a, a.length - 1, dp));
    }

    private static int minJumps(int[] a, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i <= n - 1; i++) {
            if (i + a[i] >= n) {

                if (dp[i] != Integer.MAX_VALUE) {
                    return dp[i];
                }
                int subres = minJumps(a, i, dp);
                if (subres != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], subres + 1);
                }
            }

//            } else {
//                dp[i] = Integer.MAX_VALUE;
//            }

        }
        return dp[n];
    }
}
