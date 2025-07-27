package org.example.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumTrialsEggDrop {
    public static void main(String[] args) {
        int e= 4;
        int f= 20;
        int a[] = {5,2,5,2,2,2,6};
        String s ="vaibhav";
        int[][] dp = new int[f+1][e+1];
        for(int[] row: dp ){
            Arrays.fill(row,Integer.MAX_VALUE);
        }


        Map<Character, Long> charCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount);



//        Map<Integer, Long> frequencyMap = Arrays.stream(a)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        Map<Integer, Long> frequencyMap1 = Arrays.stream(a)
//        .boxed()
//        .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
//        System.out.println(frequencyMap);
//
           System.out.println(giveMinTrials(e,f,dp));


    }
    private static int giveMinTrials(int e, int f,int[][] dp){

        if(e ==1 ){
            return f;
        }
        else if(f ==1){
            return 1;
        }
        if( f== 0 ){
            return 0;
        }
        if(dp[f][e] != Integer.MAX_VALUE){
            System.out.println("Returning f is "+f+ " E is "+e);
            return dp[f][e];
        }


        for(int i=1;i<=f;i++){
            // Breaks // Not Breaks
           int temp = Math.max(giveMinTrials(e-1,i-1,dp),giveMinTrials(e,f-i,dp))+1;
            //System.out.println("Floor "+i +" Trials  "+temp);
           dp[f][e] = Math.min(temp,dp[f][e]);

        }

        return dp[f][e];
    }
}
