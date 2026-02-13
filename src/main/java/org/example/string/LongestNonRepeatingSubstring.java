package org.example.string;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "geeksforgeeks";

        char[] chars = s.toCharArray();
      //  System.out.println(s.lastIndexOf(chars[2],5));

        boolean[] visited = new boolean[26];


        int left = 0; // 2
        int right = 0; // 9
        int max = 0;
        // geeksforgeeks
        while (right < chars.length) {
            // geeksforgeeks

            while (visited[chars[right] - 'a']) {

                visited[chars[left] - 'a'] = false;
                left++;
            }

                visited[chars[right] - 'a'] = true;
                max = Math.max(max, right - left + 1);
                right++;

        }

        System.out.println("Count is "+max);
    }
}
