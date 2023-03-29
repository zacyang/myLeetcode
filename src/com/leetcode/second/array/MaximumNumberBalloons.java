package com.leetcode.second.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberBalloons {
    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> cache = new HashMap<>();


        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            Integer val = cache.getOrDefault(aChar, 0);
            cache.put(aChar, val + 1);
        }

        int min = Integer.MAX_VALUE;
        for (char c : "balloon".toCharArray()) {

            if (c == 'l' || c == 'o') {
                min = Math.min(cache.get(c) / 2, min);
            } else {
                min = Math.min(cache.get(c), min);
            }

        }
        return min;

    }
}
