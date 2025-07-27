package org.example.mustdo.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    //Input: heights = [2,1,5,6,2,3]
    //Output: 10
    //Explanation: The above is a histogram where width of each bar is 1.
    //The largest rectangle is shown in the red area, which has an area = 10 units.
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        char[] heightsnew = {'2','1','5','6','2','3'};
       // int[] dummy = new int[3];
        //int[] arr = {60, 20, 50, 40, 10, 50, 60}; // 100
        //char[] arr = {'60', '20', '50', '40', '10', '50', '60'}; // 100
        char[][] matrix = {{'1','0'},{'1','1'},{'0','0'}};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dummy = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;

//        for (char[] row : matrix) {
//            for (int i = 0; i < cols; i++) {
//                dummy[i] = (row[i] == '1') ? dummy[i] + 1 : 0;
//            }
//        }
       // System.out.println(Arrays.toString(dummy));

       System.out.println(maximalRectangle(matrix));
        //System.out.println(largestRectangleArea(arr));
        //System.out.println(optimizedLargestRectangularArea(heightsnew));
        //System.out.println(optimizedLargestRectangularArea(heights));
    }

    public static int largestRectangleArea(int[] a) {
        Stack<Integer> st =new Stack<>();
        int n = a.length;
        int[] rsmall = new int[n];
        int[] lsmall = new int[n];
        int maxArea = 0;
        //  int[] a = {2, 4, 8, 7, 7, 9, 3};
        rightSmaller(a, n, st, rsmall);
        st = new Stack<>();
        leftSmaller(a,n,st,lsmall);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(rsmall));
//        System.out.println(Arrays.toString(lsmall));

        for (int i = 0; i < n; i++) {
            int width = rsmall[i] - lsmall[i] - 1;
            int area = a[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;




    }

    private static void rightSmaller(int[] a, int n, Stack<Integer> st, int[] rsmall) {

        Arrays.fill(rsmall,n);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]> a[i]){
                rsmall[st.pop()] = i;
            }
            st.push(i);
        }
    }

    private static void leftSmaller(int[] a, int n, Stack<Integer> st, int[] lsmall) {
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            lsmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    private static int optimizedLargestRectangularArea(char[] a){
        int area = 0;
        int n = a.length ;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<a.length;i++){
            while (!st.isEmpty() && (int)(a[st.peek()])> (int)a[i]){
                int height = st.pop(); // This the element since it is greater than a[i], it's right smaller is a[i]
                int temp = (int)(a[height]) * (st.isEmpty() ? i : i - st.peek() -1 );// prev smaller is prev element in stack
                // -1 is used to calculate difference between boundaries excluding them
                area = Math.max(area, temp);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int tp = st.pop();
            int temp = (int)(a[tp]) * (st.isEmpty() ? n : n - st.peek() -1 );
            area = Math.max(area, temp);
        }
        return area;
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // Include an extra element for easier calculation
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < cols; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }

            // Calculate max area using stack-based method
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
        }

        return maxArea;
    }
}
