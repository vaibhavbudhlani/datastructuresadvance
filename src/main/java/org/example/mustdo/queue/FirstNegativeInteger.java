package org.example.mustdo.queue;
//Input: arr[] = [-8, 2, 3, -6, 1] , k = 2
//Output: [-8, 0, -6, -6]
//Explanation: First negative integer for each window of size 2
//                        [-8, 2] = -8
//                        [2, 3]= 0 (does not contain a negative integer)
//                        [3, -6] = -6
//                        [-6, 10] = -6
//
//Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28], k = 3
//Output: [-1, -1, -7, -15, -15, 0]
//Explanation: First negative integer for each window of size 3
//                       [ 12, -1, -7] = -1
//                      [-1,-7, 8] = -1
//                     [-7, 8, -15] = -7
//                    [8, -15, 30] = -15
//                   [-15, 30, 16] = -15
//                  [30, 16, 28] = 0

import java.util.LinkedList;

public class FirstNegativeInteger {
    public static void main(String[] args) {
        int a[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
       int[] result = firstNegativeInWindow(a, k);
               System.out.println(java.util.Arrays.toString(result));
    }

    public static int[] firstNegativeInWindow(int[] arr, int k) {
            LinkedList<Integer> q = new LinkedList<>();
            int n = arr.length;
            int[] res = new int[n - k + 1];
            int idx = 0;
           //    int a[] = {12, -1, -7, 8, -15, 30, 16, 28};
            for (int i = 0; i < n; i++) {
                if (arr[i] < 0) q.add(i);

                if (i >= k - 1) {
                    if (!q.isEmpty() && q.peek() < i - k + 1) q.poll();
                    res[idx++] = q.isEmpty() ? 0 : arr[q.peek()];
                }
            }
            return res;
        }
}
