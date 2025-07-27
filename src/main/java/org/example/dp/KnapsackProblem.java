package org.example.dp;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
//        int[] v = {10, 40, 30, 50};
//        int[] wt = {5, 4, 6, 3};

        int[] v = {60,100,120};
        int[] wt = {10,20,30};

        int W = 50;

        System.out.println(giveKnapsack(v, wt, W));


    }

    private static int giveKnapsack(int[] v, int[] wt, int W) {
        int[][] dp = new int[W+1][wt.length+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return giveKnapsackAns(v, wt, W, wt.length - 1, dp);

    }

    private static int giveKnapsackAns(int[] v, int[] wt, int W, int n, int[][] dp) {
        // 5 4 6 3
        // 10 40 30 50
        if (n == 0 || W == 0) {
            return dp[W][n] = 0;
        }
        if (dp[W][n] == -1) {
            if (wt[n] > W) {
                 dp[W][n] = giveKnapsackAns(v, wt, W, n - 1, dp);
            } else {
                dp[W][n] = Math.max(v[n] + giveKnapsackAns(v, wt, W - wt[n], n - 1, dp),
                        giveKnapsackAns(v, wt, W, n - 1, dp));
            }
        }

        return dp[W][n];
    }


}
