package org.example.dp;

// In this we have been provided with a number or integer n we have to calculate BST length of that tree

// This question is a catalan number problem and formula to solve the catalan number is
// 1/N+1 2nCn

public class CountBST {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        dp[0] = 1;
        System.out.println(giveBST(n,dp));
        for(int row:dp){
            System.out.println(row);
        }
    }

    private static int giveBST(int n,int[] dp){
        // n * (n - i - 1)....
        //        dp[j] * dp[i-j-1]
        // dp[1] = dp[0] * dp[0] = 1
        // dp[2] = dp[0] * dp[1] + dp[1] * dp[0] = 1 + 1 = 2
        // dp[3] = dp[0]* dp[2] + dp[1] * dp[1] + dp[2] * dp[0] = 2 + 1 + 2 = 5
        for(int i =1;i<=n;i++){
            for(int j=0; j<i ; j++){
                dp[i] = dp[i]+ (dp[j] * dp[i - j -1]);
            }
        }
        return dp[n];

    }
}
