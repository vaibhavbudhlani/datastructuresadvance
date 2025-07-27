package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class LongestPallindromicSubstringNew {
    public static void main(String[] args) {
        String s = "abacdfgdmalayalamcaba";
        System.out.println(giveLongestPallindrome(s));
    }

    private static Set<String> giveLongestPallindrome(String s){
        Set<String> palindromes = new HashSet<>();

        // Expand around center technique of Manacher's Algorithm
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome with center i
            expandPalindrome(s, i, i, palindromes);
            // Even length palindrome with center i and i+1
            expandPalindrome(s, i, i + 1, palindromes);
        }

        return palindromes;
    }

    private static void expandPalindrome(String s, int left, int right, Set<String> palindromes) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromes.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }

}
