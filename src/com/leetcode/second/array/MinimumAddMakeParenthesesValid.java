package com.leetcode.second.array;

import java.util.Stack;

public class MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        char[] target = s.toCharArray();
        int result = 0;
        int inbalancedCounter = 0;
        for (char c : target) {
            if (c == ')') {
                if(inbalancedCounter == 0) {
                    result++;
                } else {
                    inbalancedCounter--;
                }
            } else {
                inbalancedCounter++;
            }
        }
        return result+ inbalancedCounter;
    }
}
