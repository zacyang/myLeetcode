package com.leetcode.second.stackq;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private Map corresspondedMap = new HashMap<Character, Character>();
    public ValidParentheses() {
//        corresspondedMap.put('(', ')');
        corresspondedMap.put(')', '(');
//        corresspondedMap.put('{', '}');
        corresspondedMap.put('}', '{');
//        corresspondedMap.put('[', ']');
        corresspondedMap.put(']', '[');
    }
    public boolean isValid(String s) {
//        balanced stack;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if(!stack.isEmpty() && stack.peek().equals(corresspondedMap.get(aChar))) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }

        return stack.size() == 0;
    }
}
