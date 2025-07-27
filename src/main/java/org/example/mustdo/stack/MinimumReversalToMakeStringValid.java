package org.example.mustdo.stack;

public class MinimumReversalToMakeStringValid {
    public static void main(String[] args) {

        String s = "}{{}}{{{";
        MinimumReversalToMakeStringValid obj = new MinimumReversalToMakeStringValid();
        System.out.println(obj.countMinReversals(s));
    }

    private int countMinReversals(String s){
        int left = 0;
        int right = 0;
        // If length is odd return -1
        for(char c:s.toCharArray()){
            if(c == '}'){
                if(left == 0){
                    right++;
                }
                else{
                    left--;
                }
            }
            else{
                left ++;
            }
        }
        return (int)Math.ceil(left/2.0) + (int)Math.ceil(right/2.0);

    }
}
