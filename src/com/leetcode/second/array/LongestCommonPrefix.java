package com.leetcode.second.array;
//TODO not finished
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int[] counter = new int[26];
        String baseStr = strs[0];
        char[] target = baseStr.toCharArray();
        int currentCommonMaxIdx = 0;
        for (int i = 1; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            currentCommonMaxIdx = Math.min(target.length, chars.length) -1;
            for (int j = 0; j <= currentCommonMaxIdx ; j++) {
                if(target[j] != chars[j]) {
                    currentCommonMaxIdx = j;
                }
            }
        }
        return baseStr.substring(currentCommonMaxIdx);
    }
}
