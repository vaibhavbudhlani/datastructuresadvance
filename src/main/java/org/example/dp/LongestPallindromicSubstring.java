package org.example.dp;

import java.util.Arrays;

public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        String test1 = "babad";
                     // dabab
                String test2 = "cbbd";
                String test3 = "a";
                String test4 = "ac";
        String test5 = "abacdfgdmalayalamcaba";
        System.out.println(getLongestPallindrome(test1,test1.length()));
        System.out.println(getLongestPallindrome(test2,test2.length()));
        System.out.println(getLongestPallindrome(test3,test3.length()));
        System.out.println(getLongestPallindrome(test4,test4.length()));
        System.out.println(getLongestPallindrome(test5,test5.length()));

    }

    private static int getLongestPallindrome(String s, int n){
        boolean [][] dp = new boolean[n][n];
        int start =0;
        int len = 1;

        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }

        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                len = 2;
            }
        }


        int c= getLength(s,n,dp,start,len);
//        for(boolean[] row : dp ){
//            System.out.println(Arrays.toString(row));
//        }
        return c;

    }

    private static int getLength(String s, int n, boolean[][] dp,int start,int max) {


        for(int v=2;v<n;v++) {
            for (int i = 0; i  < (n-v); i++) {
                int j = i +v;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    //System.out.println("Coming inside this "+i+"  V is "+v);
                    dp[i][j] = true;
                    start = i;
                    max = v+1;
                }
            }
        }
        // babad
        System.out.println(s.substring(start,start+max));
        return max;
    }


}
