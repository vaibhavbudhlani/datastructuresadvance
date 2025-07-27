package org.example.dp;

// To break string with min cuts so that each and every substring becomes a pallindromic substsring
// Hint - Use Partitioning like matrix chain multiplication first m0/m1...mn then mo m1 /m2...mn

import java.util.Arrays;

public class PallindromicPartitioning {
    public static void main(String[] args) {
        //String s = "abacdfgdmalayalamcaba";
        String s1 = "geek";
        String s = "abbac";
        int[][] dp = new int[s.length()][s.length()];
        for(int row[]: dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        System.out.println(givePartitioning(s,0,s.length()-1,dp));

    }

    private static int givePartitioning(String s, int i, int j, int[][] dp){

        if(isPalindrome(s, i , j)){
            return 0;
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            System.out.println("Coming inside this");
            return dp[i][j];
        }
        System.out.println("Out");
        for(int k=i;k<j;k++){
            dp[i][j] = Math.min(dp[i][j], 1 + givePartitioning(s,i,k,dp)+ givePartitioning(s,k+1,j,dp));
        }
        return dp[i][j];
    }

    private static boolean isPalindrome(String s, int i , int j){

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                   i++;
                   j--;
            }
            else{
                return false;
            }
        }
        return true;
    }


}
