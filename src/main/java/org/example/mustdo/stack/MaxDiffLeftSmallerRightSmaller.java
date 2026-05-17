package org.example.mustdo.stack;

/*Given an array of integers, the task is to find the maximum absolute difference between the nearest left and the right smaller element of every element in the array.

Note: If there is no smaller element on right side or left side of any element then we take zero as the smaller element. For example for the leftmost element, the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, the smaller element on the right side is considered as 0.

Examples:

Input: arr[] = [2, 1, 8]
Output: 1
Explanation: Left smaller  ls[] = [0, 0, 1], Right smaller rs[] = [1, 0, 0]
Maximum Diff of abs(ls[i] – rs[i]) = 1


Input: arr[] = [2, 4, 8, 7, 7, 9, 3]
Output: 4
Explanation: Left smaller  ls[] = [0, 2, 4, 4, 4, 7, 2], Right smaller  rs[] = [0, 3, 7, 3, 3, 3, 0]
Maximum Diff of abs(ls[i] – rs[i]) = 7 – 3 = 4*/

import java.util.Arrays;
import java.util.Stack;

public class MaxDiffLeftSmallerRightSmaller {
    public static void main(String[] args) {
        int[] a1 = {2, 4, 8, 7, 7, 9, 3};
        int[] a = {2, 1,8};
       // System.out.println(getAbsoluteDifference(a1,a1.length));
        System.out.println(getAbsoluteDifferenceNew(a1,a1.length));
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

    private static int getAbsoluteDifferenceNew(int[] a, int n){
        Stack<Integer> st = new Stack<>();
        int rsmaller = Integer.MAX_VALUE;
        int lsmaller = Integer.MAX_VALUE;
        int ans = 0;

        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && a[i] < a[st.peek()]){
                rsmaller = a[i];
                st.pop();

                if(!st.isEmpty()){
                    lsmaller = a[st.peek()];
                }
                else{
                    lsmaller = 0;
                }
                ans = Math.max(ans, Math.abs(rsmaller - lsmaller));
            }

            st.push(i);
        }
        while(!st.isEmpty()){
            rsmaller = 0;
            lsmaller = a[st.pop()];

            ans = Math.max(ans, rsmaller - lsmaller);
        }
        //System.out.println(rsmaller);


        return ans;
    }

    public static int findMaxDiff(int[] arr, int n)
    {
        Stack<Integer> st = new Stack<>();
        int mxDiff = 0;
        int leftSmaller, rightSmaller;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty()
                    && arr[st.peek()] > arr[i]) {
                int ind = st.peek();
                rightSmaller = arr[i]; // rightSmaller
                // element as arr[i]
                st.pop();

                if (!st.isEmpty()) {
                    leftSmaller
                            = arr[st.peek()];
                }
                else {
                    leftSmaller = 0;
                }

                mxDiff = Math.max(
                        mxDiff,
                        Math.abs(rightSmaller - leftSmaller));
            }
            if (st.isEmpty()) {
                st.push(i);
            }
            else if (arr[st.peek()] == arr[i]) {
                continue; // avoid duplicates which are
                // together
            }
            else {
                st.push(i);
            }
        }

        // Element which are still present in the stack are
        // those whose right smaller element does not exist.
        // So, for these elements, rightSmaller will be 0
        // and leftSmaller will be the element present just
        // below in the stack.
        if (!st.isEmpty()) {
            int ind = st.peek();
            rightSmaller = 0;
            st.pop();
            if (!st.isEmpty()) {
                leftSmaller = arr[st.peek()];
            }
            else {
                leftSmaller = 0;
            }
            mxDiff
                    = Math.max(mxDiff, Math.abs(rightSmaller
                    - leftSmaller));
        }

        return mxDiff;
    }


}
