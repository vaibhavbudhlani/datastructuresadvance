package org.example.dp;
// 1 2 3
// Sum = 4
// We have infinite supply of coins so 4 can be created by 1,1,1,1  2,2  1+3  2+1+1
public class CoinChange {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int sum = 4;

        System.out.println(giveAnswerCoins(a,sum,a.length-1));
    }

    private static int giveAnswerCoins(int[] a, int sum , int n){

        if(sum == 0 ){
            return 1;
        }
        if(sum < 0 ){
            return 0;
        }

        if(n== 0 ){
            return 0;
        }


        return giveAnswerCoins(a,sum-a[n],n)+  giveAnswerCoins(a,sum,n-1);

    }
}
