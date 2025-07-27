package org.example.mustdo.stack;

//Input: str = “((()”
//Output: 2
//Explanation: Longest Valid Parentheses Substring is “()”.
//
//
//Input: str = “)()())”
//Output: 4
//Explanation: Longest Valid Parentheses Substring is “()()”.
// ()(()


import java.util.Stack;

public class LongestParanthesisSubstring {
    public static void main(String[] args) {
        String s = "()(()";
        String s1 = "()(())";

        //giveMaxLengthValidSubstring(s);
        System.out.println(validUsingTwoIterations(s1));
        System.out.println(validUsingTwoIterations(s));
    }

    private static void giveMaxLengthValidSubstring(String s) {
        Stack<Character> st = new Stack<>();
        int max = 0;
        int ctr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
//                if(!st.isEmpty()){
//                    while (!st.isEmpty() && st.peek() == '('){
//                        st.pop();
//                    }
//                    ctr = 0;
//                }
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    ctr = 0;
                    continue;
                }
                if ((c == ')' && st.pop() == '(') ||
                        (c == '}' && st.pop() == '{') ||
                        (c == ']' && st.pop() == '{')) {
                    ctr = ctr + 2;
                    max = Math.max(max, ctr);
                }
            }
        }
        if(!st.isEmpty()){
            max = max - 2;
        }
        System.out.println(max);
    }

    static int maxLength(String s) {
        Stack<Integer> stack = new Stack<>();

        // Push -1 as the initial index to
        // handle the edge case
        stack.push(-1);
        int maxLen = 0;

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // If we encounter an opening parenthesis,
            // push its index
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // ()(())
                // 1 2 3
                // st = -1 2
                // If we encounter a closing parenthesis,
                // pop the stack
                stack.pop();

                // If stack is empty, push the current index
                // as a base for the next valid substring
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {

                    // Update maxLength with the current length
                    // of the valid parentheses substring
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    private static int validUsingTwoIterations(String s){
        int open = 0;
        int close = 0;
        int max = 0;

        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }
            if(s.charAt(i) == ')'){
                close++;
            }
            if(open == close){
                max = Math.max(max,open *2 );
            }
            if(open < close ){
                open = close = 0;
            }
        }
        open = close = 0;
        for(int i =s.length()-1;i>= 0;i--){
            if(s.charAt(i) == '('){
                open++;
            }
            if(s.charAt(i) == ')'){
                close++;
            }
            if(open == close){
                max = Math.max(max,open *2 );
            }
            if(open > close ){
                open = close = 0;
            }
        }

        return max;
    }
}
