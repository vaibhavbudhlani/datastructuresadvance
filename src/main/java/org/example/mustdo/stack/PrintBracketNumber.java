package org.example.mustdo.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintBracketNumber {
    public static void main(String[] args) {
        String s = "(aa(bdc))p(dee)";
         PrintBracketNumber obj = new PrintBracketNumber();
         obj.printBracket(s).forEach(x-> System.out.print(x+" "));
    }


    private List<Integer> printBracket(String s) {
        Stack<Integer> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        int open = 1;

         for(char c:s.toCharArray()){
             if(c == '('){
                 st.push(open);
                 ls.add(open);
                 open++;
             }
             else if(c == ')'){
                 if(!st.isEmpty()){
                     ls.add(st.pop());
                 }
             }
         }
         return ls;
    }
}
