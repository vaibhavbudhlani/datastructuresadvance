package org.example.mustdo.stack;

import java.util.Stack;

public class DuplicateParanthesisOrNot {
    public static void main(String[] args) {
        String invalid = "((a+b)+((c+d)))";
        String valid = "((a+b)+(c+d))";

        System.out.println(checkDuplicates(invalid));
        System.out.println(checkDuplicates(valid));
    }

    private static String checkDuplicates(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ')'){
                if(st.peek() == '('){
                    return "Invalid";
                }
                else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty()?"Valid":"Invalid";
    }
}
