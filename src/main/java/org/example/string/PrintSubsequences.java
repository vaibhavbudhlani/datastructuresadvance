package org.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsequences {
    private static List<String> ls = new ArrayList<>();
    public static void main(String[] args) {
        String s = "abc";
        String vb = "a";

        printSubsequence(s);
        ls.forEach(System.out::println);
    }

    static void printSubsequence(String s){

        printSubsequenceArray("",s);

    }

    static void printSubsequenceArray(String ans, String s){

          if(s.isEmpty()){
              ls.add(ans);
              return;
          }

          printSubsequenceArray(ans+s.charAt(0),s.substring(1));

          printSubsequenceArray(ans,s.substring(1));
    }


}
