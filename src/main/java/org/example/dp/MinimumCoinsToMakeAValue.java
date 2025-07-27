package org.example.dp;

import java.util.Arrays;

public class MinimumCoinsToMakeAValue {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int sum = 149;

        long[] dp = new long[sum +1];
        Arrays.fill(dp,Integer.MAX_VALUE);

         long result = minCoins(coins, sum, dp);
         int  ans = (int)Arrays.stream(dp).max().orElse(1);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static long minCoins(int[] coins, int sum, long[] dp) {
        if (sum == 0) return 0;
        if (sum < 0) {
            System.out.println("Will it come");
            return Integer.MAX_VALUE;
        }
        if (dp[sum] != Integer.MAX_VALUE) {
            System.out.println("Getting Value from DP");
            return dp[sum];
        }
        System.out.println("Normal");


        for (int coin : coins) {
            if( sum >= coin) {
                //long res = minCoins(coins, sum - coin, dp);
                dp[sum] = Math.min(dp[sum], 1 + minCoins(coins,sum-coin,dp));
            }
        }


        return dp[sum];
    }


}