package org.example.mustdo.queue;

//Input: n = 2
//Output: 1, 10
//Explanation: The first two non-zero numbers with digits as 0 and 1 only
//
//Input: n = 5
//Output: 1, 10, 11, 100, 101

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        int n = 8;

        Queue<String> q = new LinkedList<>();

        q.add("1");
        while (n > 0) {

            String s1 = q.poll();
            System.out.println(s1);
            q.add(s1 + "0");
            q.add(s1 + "1");
            n--;
        }
    }
}
