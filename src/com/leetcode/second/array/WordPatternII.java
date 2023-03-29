package com.leetcode.second.array;

import java.util.*;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String s) {
        char[] patternChars = pattern.toCharArray();
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (char patternChar : patternChars) {
            Integer counter = characterIntegerHashMap.getOrDefault(patternChar, 0);
            characterIntegerHashMap.put(patternChar, counter + 1);
        }
        Integer totalPatternCounts = characterIntegerHashMap.values().stream().reduce((a, b) -> a + b).get();

//         each pattern can choice from 1 -> len(s) - sum(all other pattern * 1)
        Map<Character, String> register = new HashMap<>();
        return backTracking(0, patternChars, s, totalPatternCounts, characterIntegerHashMap, register);
    }

    private boolean backTracking(int indexOfPattern, char[] patternChars, String targetS, Integer totalPatternCounts, HashMap<Character, Integer> characterIntegerHashMap, Map<Character, String> register) {
        if(targetS.isEmpty()) {
            return true;
        }
        if(indexOfPattern>patternChars.length-1) {
            return false;
        }
        char patternChar = patternChars[indexOfPattern];

        int possibleMaxSubStringLen = targetS.length() - totalPatternCounts - characterIntegerHashMap.get(patternChar);

        for (int i = 1; i < possibleMaxSubStringLen; i++) {
            String replacedTarget = targetS.substring(0, i);
            String newTargetS = targetS.replace(replacedTarget, "");

            int reminderPatternCounts = totalPatternCounts - characterIntegerHashMap.get(patternChar) *i;
            if (backTracking(indexOfPattern + 1, patternChars, newTargetS, reminderPatternCounts, characterIntegerHashMap, register)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new WordPatternII().wordPatternMatch("abab", "redblueredblue"));
        System.out.println(new WordPatternII().wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}
