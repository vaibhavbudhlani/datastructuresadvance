package org.example.mustdo.stack;
// Input: expression = "T?2:3"
//Output: "2"
//Explanation: If true, then result is 2; otherwise result is 3.

//Input: expression = "F?1:T?4:5"
//Output: "4"
//Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
//"(F ? 1 : (T ? 4 : 5))" --> "(F ? 1 : 4)" --> "4"
//or "(F ? 1 : (T ? 4 : 5))" --> "(T ? 4 : 5)" --> "4"

import java.util.Stack;

public class TernaryParser {
    public static void main(String[] args) {
        String s = "T?T?F:5:3";
        String s1 = "F?1:T?4:5";
        TernaryParser p = new TernaryParser();
        System.out.println(p.resolveTernaryParser(s1, s1.length()));
    }

    public String resolveTernaryParser(String s, int n) {
        boolean cond = false;
        Stack<Character> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ':') {
                continue;
            }
            if (c == '?') {
                cond = true;
            } else {
                if (cond) {
                    if (c == 'T') {
                        char v = st.pop();
                        st.pop();
                        st.push(v);
                    } else {
                        st.pop();
                    }
                    cond = false;
                }
                else {
                    st.push(c);
                }
            }
        }
        return String.valueOf(st.peek());
    }
}
