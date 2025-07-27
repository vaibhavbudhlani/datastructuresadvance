package org.example.mustdo.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircularArray {
    public static void main(String[] args) {
        int[] a1 = {1,2,1};
        int[] a ={1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(a)));
        }

    public static int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int []arr= new int[len];
        Stack<Integer> s1= new Stack<>();

        for(int i=len*2-1 ; i>=0 ; i--){
            // int[] a ={1,2,3,4,3};
            while(!s1.isEmpty() && s1.peek()<=nums[i%len]){
                s1.pop();
            }

            if(i<len){
                if(!s1.isEmpty()){
                    arr[i]=s1.peek();
                }
                else{
                    arr[i]=-1;
                }
            }
            s1.push(nums[i % len]);
        }
        return arr;
    }

    }

