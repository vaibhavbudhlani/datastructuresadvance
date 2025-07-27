package org.example;

import java.util.Arrays;
// This gives us number of ways if you want to practice number of coins needed go to maximum cut
public class CoinChange {
    public static void main(String[] args) {
        int[] coins1 = {1,2,3};
        int[] coins = {12,11,13};
        //int[] coins = {1,2,3};
        int amount = 23;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(coinChange(coins, amount, coins.length - 1, dp));
    }

    private static int coinChange(int[] coins, int amount, int n, int[][] dp) {
        System.out.println("N is "+n+" Amount is  "+amount);
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || n < 0) {
            return 0;
        }
        if (dp[n][amount] != -1) {
            System.out.println("Coming inside this loop where n and amount are "+n+"  "+amount);
            return dp[n][amount];
        }

        dp[n][amount] = coinChange(coins, amount - coins[n], n, dp) + coinChange(coins, amount, n - 1, dp);
        return dp[n][amount];
    }
}