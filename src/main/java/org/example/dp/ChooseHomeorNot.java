package org.example.dp;

import java.util.Arrays;

public class ChooseHomeorNot {
    public static void main(String[] args) {
        int[] a = {6, 4, 7, 8, 4, 7, 1, 7, 3, 6};
        int[] a1 = {5, 3, 4, 11, 2};
        int[] dp = new int[a.length];
        Arrays.fill(dp,-1);

        System.out.println(giveFinalAns(a,a.length-1,dp));

        //Arrays.stream(dp).forEach(System.out::println);
    }

    private static int giveFinalAns(int[] a, int n,int[] dp){
//        if(n == 1){
//            return a[0];
//        }
//        if(n ==2 ){
//            return Math.max(a[0],a[1]);
//        }  // Test Cases will fail due to this
        if(dp[n] != -1){
            return dp[n];
        }
       // System.out.println("Coming inside this ");

         dp[n] = Math.max(a[n]+ giveFinalAns(a,n-2,dp),giveFinalAns(a,n-1,dp));
         return dp[n];
    }
}
