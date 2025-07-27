package org.example.dp;

// Variation of LIS
//  1 2 3 4 5 6
//  1 2 3 4 5 6

// Idea is to Sort the array based on the first number and make Lis out of Second Number

import java.util.Arrays;
import java.util.Comparator;

public class BuildingBridges {
    public static void main(String[] args) {
        int a1[][] = {{6,2},{4,3},{2,6},{1,5}};
        int a[][] = {{8,1},{1,2},{4,3},{3,4},{5,5},{2,6},{6,7},{7,8}};
        // {5,24} ,{39,60} ,{15,28} ,{27,40} ,{50,90}
        // 524  1528  2740 3960  5090
        // 524   1528      2740   3960    5090

        // 68  34

        System.out.println(giveAnswer(a));
    }

    public static int giveAnswer(int[][] a){

        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        System.out.println(Arrays.deepToString(a));
        System.out.println("Length of a "+a.length);
        System.out.println("Length of a o is "+a[0].length);
        int lis[] = new int[a.length];

        for(int i=0;i<a.length;i++){
             lis[i] = 1;
            for(int j=0;j<i;j++){
               if(a[i][1] > a[j][1]){
                   lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(lis));
        int maxLis = Arrays.stream(lis).max().orElse(1);
        System.out.println(maxLis);


        //System.out.println(Arrays.deepToString(a));


        return maxLis;
    }

}
