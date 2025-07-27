package org.example.mustdo.logic;

public class ValidateStack {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,1,2};
        ValidateStack v = new ValidateStack();
        System.out.println(v.validateStackSequences(pushed,popped));
    }

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        int i =0;
        int j = 0;

        for(int val:pushed){
            pushed[i++] = val;
            while(i>0  && pushed[i-1] == popped[j]){
                i--;
                j++;
            }
        }

        return i==0;
    }
}
