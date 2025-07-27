package org.example.string;

import java.util.Arrays;
import java.util.Collections;

public class MaximumLengthBitonicSubsequence {
    public static void main(String[] args) {
        int a1[] = {1,11,2,10,4,5,2,1};
        int a2[]= {12,11,40,5,3,1};
        int a8[]= {30,20,10};
        int a[] = {1,2,3};

        System.out.println(giveAnswer(a));

    }

    public static int giveAnswer(int[] a){

        int[] lis = giveLis(a);
        int[] lds = givelds(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(lds));
        // Take max out of them
        return 1;
    }



    private static int[] giveLis(int[] a){
        int[] lis = new int[a.length];

        for(int i=0;i<a.length;i++){
            lis[i] = 1;
            for (int j =0 ; j < i ; j++){
                if(a[i] > a[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        return lis;
    }

    private static int[] givelds(int[] a){
        int lds[] = new int[a.length];

        for (int i = a.length-1 ; i >= 0 ; i --){
            lds[i] = 1;
            for(int j = a.length -1 ; j > i ; j--){
                if(a[i] > a[j]){
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        return lds;
    }
}

