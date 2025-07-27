package org.example.check;

import java.util.Stack;

public class StackCheck {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
        // 2 5 8 2 4
    }

    public static int countGoodNumbers(long n) {
        long sum = 1;
        int even = 5;
        int prime = 4;
        for(int i=1;i<=n;i++){
            if(i%2 == 0){
                sum = (sum * prime)% 1000000007;
            }
            else{
                sum = (sum * even)% 1000000007;
            }
        }
       return (int)sum ;

    }
}
