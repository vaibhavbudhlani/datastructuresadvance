package org.example.mustdo.stack;

//Example 1:
//
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
//Example 2:
//
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
//Example 3:
//
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[abc2[def]]";


        System.out.println(decodeString(s));
    }

    private static String decodeString(String s){

        Stack<Integer> cstack = new Stack<>();
        Stack<StringBuilder> sstack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                n = n * 10 + (c - '0');
            }
            else if(c == '['){
                cstack.push(n);
                n =0;
                sstack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int k = cstack.pop();
                StringBuilder temp = sb;
                sb = sstack.pop();
                while(k-- > 0){
                    sb.append(temp);
                }

            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
