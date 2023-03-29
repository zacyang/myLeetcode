package com.leetcode.second.array;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean firstWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (firstWord && s.charAt(i) == ' ') {
                return len;
            }
            if (s.charAt(i) != ' ') {
                firstWord = true;
                len++;
            }
        }
        return len;
    }
}
