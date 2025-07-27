package org.example.mustdo.stack;

//Given an array of integers, the task is to find the maximum absolute difference between the nearest left and the right smaller element of every element in the array.
//
//Note: If there is no smaller element on right side or left side of any element then we take zero as the smaller element. For example for the leftmost element, the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, the smaller element on the right side is considered as 0.
//
//Examples:
//
//Input: arr[] = [2, 1, 8]
//Output: 1
//Explanation: Left smaller  ls[] = [0, 0, 1], Right smaller rs[] = [1, 0, 0]
//Maximum Diff of abs(ls[i] – rs[i]) = 1
//
//
//Input: arr[] = [2, 4, 8, 7, 7, 9, 3]
//Output: 4
//Explanation: Left smaller  ls[] = [0, 2, 4, 4, 4, 7, 2], Right smaller  rs[] = [0, 3, 7, 3, 3, 3, 0]
//Maximum Diff of abs(ls[i] – rs[i]) = 7 – 3 = 4

import java.util.Arrays;
import java.util.Stack;

public class MaxDiffLeftSmallerRightSmaller {
    public static void main(String[] args) {
        int[] a1 = {2, 4, 8, 7, 7, 9, 3};
        int[] a = {2, 1,8};
        int i ;
        for( i=0;i<2;i++){

        }
        System.out.println(getAbsoluteDifference(a,a.length));
    }

    private static int getAbsoluteDifference(int[] a, int n){
        Stack<Integer> st =new Stack<>();
        int[] rsmall = new int[n];
        int[] lsmall = new int[n];

        //  int[] a = {2, 4, 8, 7, 7, 9, 3};
        for(int i= n-1;i>=0 ;i--){
            while(!st.isEmpty() && st.peek()>=a[i]){
                st.pop();
            }
            rsmall[i] = st.isEmpty() ? 0 : st.peek();
            st.push(a[i]);
        }
        st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=a[i]){
                st.pop();
            }
            lsmall[i] = st.isEmpty() ? 0 : st.peek();
            st.push(a[i]);
        }
        int max = 0;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(lsmall));
        System.out.println(Arrays.toString(rsmall));
        for(int i=0;i<n;i++){
            max = Math.max(max,Math.abs(lsmall[i] - rsmall[i]));
        }
        //max = IntStream.range(0, n)
        //               .map(i -> Math.abs(lsmall[i] - rsmall[i]))
        //               .max()
        //               .orElse(0);


        return max;
    }


}
