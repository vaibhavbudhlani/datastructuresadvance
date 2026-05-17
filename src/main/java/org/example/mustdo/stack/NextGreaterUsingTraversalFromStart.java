package org.example.mustdo.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterUsingTraversalFromStart {
    public static void main(String[] args) {
        int[] a ={1,4,3,5,2};
        int[] res = new int[a.length];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
       //
        for(int i=0;i<a.length;i++){
            //while(!st.isEmpty() && a[i] <= a[st.peek()]){  // For Right smaller
            while(!st.isEmpty() && a[i] >= a[st.peek()]){
                 res[st.pop()] = a[i];
            }
            st.push(i);
        }

        System.out.println(Arrays.toString(res));
    }
}
