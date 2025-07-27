package org.example.string;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        //int a1[][] = {{6,2},{4,3},{2,6},{1,5}};
       // int[][] a = {{8,1},{1,4},{1,2},{4,3},{3,4},{5,5},{2,6},{2,5},{6,7},{7,8}};
        int[] a = {25,10,5};
        int sum = 30;
        System.out.println(giveMinimumCoins(a,sum,a.length));

        //System.out.println(buildBridge(a));
    }

    public static int giveMinimumCoins(int[] a,int sum,int n){
        int res = Integer.MAX_VALUE;
        if(sum == 0 ){
            return 0;
        }
        //25 10 5

           for(int i =0;i<n ; i++){

               if(a[i] <= sum ) {
                   int sub_res = giveMinimumCoins(a, sum - a[i], n);

                   if (sub_res != Integer.MAX_VALUE) {
                       res = Math.min(res,sub_res + 1);
                   }
               }
           }


      return res;
    }

    public static int buildBridge(int[][] a){
        Arrays.stream(a).sorted((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1]- o2[1];
            }
           return o1[0]- o2[0];

        });
        return 1;
    }
}
