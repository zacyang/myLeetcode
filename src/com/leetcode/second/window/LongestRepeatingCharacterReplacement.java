package com.leetcode.second.window;

import java.util.*;

import java.util.stream.Collectors;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int startIdx = 0, endIdx = 0;
        Map<Character, Integer> appearanceRegister = new HashMap<>();

        int longest = 0;
        while (endIdx < s.length()) {
            char startChar = s.charAt(endIdx);
            appearanceRegister.compute(startChar, (character, integer) -> {
                if(integer == null) {
                    return  1;
                } else {
                    return 1+ integer;
                }
            });


            List<Integer> sorted = appearanceRegister.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            Integer maxCount = sorted.get(0);

            if((endIdx-startIdx+1-k) > maxCount) {
                appearanceRegister.compute(s.charAt(startIdx),   (character, integer) -> integer -1);
                startIdx++;

            } else {
//                could be the longest
                longest = Math.max(longest, endIdx - startIdx+1);
            }

            endIdx++;

        }

        return longest;
    }

    public static void main(String[] args) {
        int result = new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1);
//        int result = new LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2);
        System.out.println(result);
    }
}
