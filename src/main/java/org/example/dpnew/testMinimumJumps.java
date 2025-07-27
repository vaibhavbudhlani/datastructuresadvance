package org.example.dpnew;
import java.util.Arrays;

public class testMinimumJumps {
    public static void main(String[] args) {
        int[] a = {3, 4, 2, 1, 2, 1};
        int[] a1 = {4, 1, 5, 3, 1, 3, 2, 1, 8};
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        System.out.println(minJumps(a, a.length - 1, dp));
        System.out.println(Arrays.toString(dp));
    }

    public static int minJumps(int[] a, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 1; i++) {
            if ((i + a[i]) >= n) {
                int sub = minJumps(a, i, dp);
                if (sub != Integer.MAX_VALUE) {
                    res = Math.min(res, sub + 1);
                }
            }
        }
        dp[n] = res;
        return res;
    }
}