package org.example;
//Input: S = “GEEKSFORGEEKS”
//Output: 5
//Explanation: The longest palindromic subsequence we can
// get is of length 5. There are more than 1 palindromic subsequences of
// length 5, for example: EEKEE, EESEE, EEFEE, …etc.
//
//Input: S = “BBABCBCAB”
//Output: 7
//Explanation: As “BABCBAB” is the longest
// palindromic subsequence in it. “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.

import java.util.Arrays;

public class LongestPallindromicSubsequence {
    public static void main(String[] args) {

//        String s = "TBNMHCACTATA";
//                 //"ATATCACHMNBT"
//        //          BACBCBABB
//        String reverse = new StringBuilder(s).reverse().toString();
//
//        int[][] dp = new int[s.length() + 1][reverse.length() + 1];
//        for (int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//
//        System.out.println(lcs(s, reverse, s.length(), reverse.length(), dp));
//        for(int[] row:dp){
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println(givelcs(s,reverse,s.length(),reverse.length(),dp));

        testLongestPalindromicSubsequence();


    }

    private static int lcs(String s1, String s2, int n, int m, int[][] dp) {

        if (n == 0 || m == 0) {
            return dp[n][m] = 0;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        } else {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                dp[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, dp);
            } else {
                dp[n][m] = Math.max(lcs(s1, s2, n - 1, m, dp), lcs(s1, s2, n, m - 1, dp));
            }
        }



        return dp[n][m];

    }

    private static int lcsnew(String s1, String s2, int n, int m, int[][] dp) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    private static String givelcs(String s1,String s2, int n, int m ,int[][] dp){
        StringBuilder lps = new StringBuilder();
        while (n > 0 && m > 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                lps.append(s1.charAt(n - 1));
                n--;
                m--;
            } else if (dp[n - 1][m] > dp[n][m - 1]) {
                n--;
            } else {
                m--;
            }
        }
        return lps.reverse().toString();
    }

    private static void testLongestPalindromicSubsequence() {
        // Test case 1: Empty string
        test("", 0);

        // Test case 2: Single character
        test("A", 1);

        // Test case 3: All characters same
        test("AAAA", 4);

        // Test case 4: No palindromic subsequence longer than 1
        test("ABCDE", 1);

        // Test case 5: General case
        test("TBNMHCACTATA", 5);
    }

    private static void test(String s, int expectedLength) {
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][reverse.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int length = lcs(s, reverse, s.length(), reverse.length(), dp);
        String lps = givelcs(s, reverse, s.length(), reverse.length(), dp);
        System.out.println("Input: " + s);
        System.out.println("Expected Length: " + expectedLength);
        System.out.println("Calculated Length: " + length);
        System.out.println("Longest Palindromic Subsequence: " + lps);
        System.out.println();
    }


}
