package org.example.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 3, 4 };
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        int res = matrixMultiplication(arr,0,arr.length-1,dp);
        System.out.println(res);
//        for(int[] row: dp){
//            System.out.println(Arrays.toString(row));
//        }
    }

    private static int matrixMultiplication(int[] a, int i , int j,int[][] dp){
        if(i +1 == j){
            return 0;
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            System.out.println("Coming inside this");
            return dp[i][j];
        }

        for(int k= i +1; k<j; k ++){
            dp[i][j] = Math.min(dp[i][j], matrixMultiplication(a,i,k,dp) + matrixMultiplication(a,k,j,dp)
             + (a[i]* a[k]* a[j]));
        }
        return dp[i][j];
    }
}
