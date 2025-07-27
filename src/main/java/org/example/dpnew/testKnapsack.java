package org.example.dpnew;

public class testKnapsack {
    public static void main(String[] args) {
        int[] v = {60,100,120};
        int[] wt = {10,20,30};

        int W = 50;

        System.out.println(giveKnapsackNew(v, wt, W,v.length));

    }

    private static int giveKnapsackNew(int[] v, int[] wt, int W, int n){

        if(n == 0 ){
            return 0;
        }

        if(wt[n-1] > W){
            return giveKnapsackNew(v,wt,W,n-1);
        }
        else{
            return Math.max(giveKnapsackNew(v,wt,W,n-1),v[n-1]+
                    giveKnapsackNew(v,wt,W-wt[n-1],n-1));
        }


    }
}
