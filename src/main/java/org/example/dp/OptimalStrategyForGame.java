package org.example.dp;

// we need to find max value a user can choose if he choose one coin at a time from ends of the array

import java.util.Arrays;

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        int[] a1 ={20,5,4,6};
        int[] a = {2,3,15,7};
        int[] a3 = {9,1,2};
        int[][] dp = new int[a.length+1][a.length+1];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        //int sum = 25;
        System.out.println(giveOptimalStrategy(a,0,a.length-1,dp));
    }
    // i --> i+1 ....j
    // j --> i .....j-1

    private static int giveOptimalStrategy(int[] a,int i, int j,int[][] dp){
        if (i > j) {
            return 0;
        }
        if(i+1 == j){
            return dp[i][j] = Math.max(a[i],a[j]);
        }
        System.out.println("Coming inside this i is "+i+" J is "+j+ "dp "+dp[i][j]);
        if(dp[i][j] != -1 ){
            System.out.println("***************Coming inside this i is "+i+" J is "+j+ "dp "+dp[i][j]);
            return dp[i][j];
        }

        dp[i][j] =Math.max(a[i] + Math.min(giveOptimalStrategy(a,i+2,j,dp),giveOptimalStrategy(a,i+1,j-1,dp)),
                a[j] + Math.min(giveOptimalStrategy(a,i+1,j-1,dp),giveOptimalStrategy(a,i,j-2,dp)));
        return dp[i][j];

    }
}
