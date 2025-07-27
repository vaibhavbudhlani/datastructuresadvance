package org.example.mustdo;

import java.util.*;

public class FrogJump {
    public static boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        // Map to store the possible jump sizes for each stone
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        // The first stone can only be reached with a jump of size 0
        dp.get(0).add(0);

        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                // Check possible jump sizes: k-1, k, k+1
                for (int step = jump - 1; step <= jump + 1; step++) {
                    if (step > 0 && dp.containsKey(stone + step)) {
                        dp.get(stone + step).add(step);
                    }
                }
            }
        }

        // If the last stone has any reachable jumps, return true
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones1 = {0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones1)); // Output: true
    }
}