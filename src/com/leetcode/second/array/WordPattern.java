package com.leetcode.second.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] wordSplit = s.split(" ");
        if (wordSplit.length != chars.length) {
            return false;
        }

        Map<Object, Integer> patternRegister = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if(!patternRegister.containsKey(chars[i])) {
                patternRegister.put(chars[i], i);

            }
            if(!patternRegister.containsKey(wordSplit[i])) {
                patternRegister.put(wordSplit[i], i);
            }

            if(!patternRegister.get(chars[i]).equals(patternRegister.get(wordSplit[i]))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new WordPattern().wordPattern("abba", "dog cat cat fish");
    }
}
