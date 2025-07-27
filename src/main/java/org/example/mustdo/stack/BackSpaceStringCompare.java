package org.example.mustdo.stack;
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
//Example 2:
//
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
//Example 3:
//
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".

import java.util.Stack;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        BackSpaceStringCompare obj = new BackSpaceStringCompare();
        String s1 = "ab#c";
        String t1 = "ad#c";

        String s = "a#c";
        String t = "b";

        System.out.println(obj.stringCompare(s,t));
        System.out.println(obj.build(s).equals(obj.build(t)));
    }

    public boolean stringCompare(String s, String t) {
           int n = s.length()-1;
           int m = t.length()-1;
           int skipn =0;
           int skipm = 0;
           while(n >= 0 && m>=0){
               while(n>=0){
                   if(s.charAt(n) == '#'){
                       skipn++;
                       n--;
                   }
                   else if( skipn > 0){
                       n--;
                       skipn--;
                   }
                   else{
                       break;
                   }
               }
               while(m>=0){
                   if(t.charAt(m) == '#'){
                       skipm++;
                       m--;
                   }
                   else if( skipm > 0){
                       m--;
                       skipm--;
                   }
                   else{
                       break;
                   }
               }
                if((n>=0 && m>=0) && s.charAt(n) != t.charAt(m)){
                   return false;
               }
               if( (n>=0) != (m>=0) ){
                   return false;
               }
               n--;
               m--;
           }
           return true;
    }
    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
