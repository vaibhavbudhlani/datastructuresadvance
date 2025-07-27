package org.example.mustdo.stack;
//Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
//Output: [1, 1, 1, 2, 1, 4, 6]
//Explanation: Traversing the given input span 100 is greater than equal to 100 and there are no more elements behind it so the span is 1, 80 is greater than equal to 80 and smaller than 100 so the span is 1, 60 is greater than equal to 60 and smaller than 80 so the span is 1, 70 is greater than equal to 60,70 and smaller than 80 so the span is 2 and so on.  Hence the output will be 1 1 1 2 1 4 6.
//
//
//Input: arr[] = [10, 4, 5, 90, 120, 80]
//Output: [1, 1, 2, 4, 5, 1]
//Explanation: Traversing the given input span 10 is greater than equal to 10 and there are no more elements behind it so the span is 1, 4 is greater than equal to 4 and smaller than 10 so the span is 1, 5 is greater than equal to 4,5 and smaller than 10 so the span is 2,  and so on. Hence the output will be 1 1 2 4 5 1.

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] a = {100, 80, 60, 70, 60, 75, 85};
        //Output: [1, 1, 1, 2, 1, 4, 6]
        Stack<Integer> st = new Stack<>();
        int[] res = new int[a.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < a.length; i++) {

              while(!st.isEmpty() && a[st.peek()] <= a[i]){
                  st.pop();
              }
              if(st.isEmpty()){
                   res[i] = i+1;
              }
              else{
                   int peek = st.peek();
                   res[i] = i - peek;
              }
              st.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}
