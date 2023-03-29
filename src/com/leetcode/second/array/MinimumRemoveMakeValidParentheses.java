package com.leetcode.second.array;

public class MinimumRemoveMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int inbalancedCounter = 0;
        int max = 0;
        char[] target = s.toCharArray();

        for (char c : target) {
            if (c == '(') {
                inbalancedCounter++;
            } else if (c == ')') {
                inbalancedCounter--;
            }
            max = Math.max(inbalancedCounter, max);

        }

        return "";

    }
}
