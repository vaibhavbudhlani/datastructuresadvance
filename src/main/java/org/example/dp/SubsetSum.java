package org.example.dp;

// To calculate subsets we have to use pick and non pick strategy.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int a[] = {1,1,8};
        int sum = 3;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subs = new ArrayList<>();
        int n = a.length;
        int[][] dp = new int[n+1][sum+1];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        // subsetRecur(0,a,res,subs);
        System.out.println(subsetSum(a,a.length,sum,dp));
        for(int[] row : dp){
            System.out.println(Arrays.toString(row));
        }


    }



    private static  int subsetSum(int[] a, int n, int sum, int[][] dp){

        if(sum < 0 ){
            return 0;
        }

        if( n== 0 ){

           return sum == 0 ? 1 : 0;
        }

        if(dp[n][sum] != Integer.MIN_VALUE){
            return dp[n][sum];
        }
        System.out.println("Coming inside this ..");
        dp[n][sum] =  subsetSum(a,n-1,sum,dp ) + subsetSum(a,n-1,sum - a[n-1],dp);
        return dp[n][sum];


    }

    static void subsetRecur(int i, int[] arr,
                            List<List<Integer>> res, List<Integer> subset) {

        // add subset at end of array
        if (i == arr.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // include the current value and
        // recursively find all subsets
        subset.add(arr[i]);
        subsetRecur(i + 1, arr, res, subset);

        // exclude the current value and
        // recursively find all subsets
        subset.remove(subset.size() - 1);
        subsetRecur(i + 1, arr, res, subset);
    }
}
