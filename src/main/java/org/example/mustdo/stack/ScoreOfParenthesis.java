package org.example.mustdo.stack;
//Input: s = "()"
//Output: 1
//Example 2:
//
//Input: s = "(())"
//Output: 2
//Example 3:
//
//Input: s = "()()"
//Output: 2

// Input s = "(()(()))"
// output = 6

import java.util.Stack;

public class ScoreOfParenthesis {
    public static void main(String[] args) {
        String s1 = "(()(()))";
        String s = "((()))";
        int ctr =0;
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '('){
                ctr++;
            }
            else{
                if(s.charAt(i-1) == '('){
                    st.push(ctr);
                }
                ctr--;
            }
        }
        int ans = 0;
        for(int i=st.size();i>0;i--){
            ans = ans + (int)Math.pow(2, st.pop()-1);
        }
        System.out.println(String.valueOf(st));
        System.out.println(ans);
    }
}
