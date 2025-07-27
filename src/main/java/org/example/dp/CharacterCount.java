package org.example.dp;

import java.util.Map;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String vb = "geeks";
        Map<Character, Long> charCount = vb.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
         System.out.println(charCount);

    }
}
