package org.example.mustdo.stack;
// Answer - stack
//Input: arr[] = [1, 3, 2, 4]
//Output: [3, 4, 4, -1]
//Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn’t exist, it is -1.
//
//
//Input: arr[] = [6, 8, 0, 1, 3]
//Output: [8, -1, 1, 3, -1]
//Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on right and hence -1.
//
//
//Input: arr[] = [50, 40, 30, 10]
//Output: [-1, -1, -1, -1]
//Explanation: There is no greater element for any of the elements in the array, so all are -1.

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] a1 = {6, 8, 0, 1, 3};
        int[] a = {1, 3, 2, 4};
        int n = a.length;
        boolean flag = true;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(ans, -1);

//        for (int i = 0; i < n; i++) {
//            flag = false;
//            for (int j = i + 1; j < n; j++) {
//                if (a[j] > a[i]) {
//                    flag = true;
//                    a[i] = a[j];
//                    break;
//                }
//            }
//            if (!flag) {
//                a[i] = -1;
//            }
//        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= a[i]) {
                st.pop();
            }

            if(st.isEmpty()){
                ans[i]= -1;
            }
            else{
                ans[i]= st.peek();
            }
            st.push(a[i]);
        }
        System.out.println(Arrays.toString(ans));


    }
}
