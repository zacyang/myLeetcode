package com.leetcode.second.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t==null || s== null || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> targetRegister = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetRegister.compute(c, (k,v) -> v==null? 1: v +1);
        }

        int windowStart = 0, windowEnd = 0;


        String minSubStr = s;
        boolean foundMatch = false;
        while (windowEnd <= s.length() - 1) {
            if (targetRegister.get(s.charAt(windowEnd)) != null) {
                targetRegister.compute(s.charAt(windowEnd), (k, v) ->  v -1 );
            }


            while (allfound(targetRegister) && windowStart<=windowEnd) {
                foundMatch = true;
                char key = s.charAt(windowStart);
                Integer times = targetRegister.get(key);
                if (times != null) {
                    targetRegister.put(key, times + 1);
                }
                String currentSubStr = s.substring(windowStart, windowEnd + 1);
                minSubStr = minSubStr.length() > currentSubStr.length() ? currentSubStr : minSubStr;
                windowStart++;

            }

            windowEnd++;


        }

        return foundMatch?minSubStr:"";
    }

    private boolean allfound(Map<Character, Integer> tmpRegister) {
        return tmpRegister.values().stream().allMatch(v -> v <= 0);
    }

    public static void main(String[] args) {
        String s = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
