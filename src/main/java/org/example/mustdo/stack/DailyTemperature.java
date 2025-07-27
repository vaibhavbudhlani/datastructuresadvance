package org.example.mustdo.stack;
//Given an array of integers temperatures represents the daily temperatures,
// return an array answer such that answer[i] is the number of days you have to
// wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//
//
//
//Example 1:
//
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
//Example 2:
//
//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
//Example 3:
//
//Input: temperatures = [30,60,90]
//Output: [1,1,0]

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] a = {73,74,75,71,69,72,76,73};
        int n = a.length;
       // int[][] vb = {{2, 4},{5,6},{5,6,7}};
//        System.out.println(vb[0][0]);
//        System.out.println(vb[0][1]);
        int[] res= new int[n];

        Stack<int[][]> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()[0][0]<= a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = 0;
            }
            else{
                int[][] peeked = st.peek();
                res[i] = peeked[0][1] - i;
            }
            int[][] vb = {{a[i],i}};
            st.push(vb);
        }
        System.out.println(Arrays.toString(res));

    }
}
