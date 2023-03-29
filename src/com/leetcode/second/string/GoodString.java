package com.leetcode.second.string;

import java.util.Stack;

public class GoodString {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> register = new Stack<>();
        for (char aChar : chars) {
            if (!register.isEmpty() && !register.peek().equals(aChar) && Character.toUpperCase(register.peek()) == Character.toUpperCase(aChar)) {
                register.pop();
            }
            register.push(aChar);


        }
        StringBuilder ans = new StringBuilder();
        for (char currChar : register)
            ans.append(currChar);
        return ans.toString();
    }
}
