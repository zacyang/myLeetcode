package com.leetcode.second.string;

import java.util.Stack;

public class ReverseWordsString {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        String[] originalWords = s.split(" ");
        for (String originalWord : originalWords) {
            if (!originalWord.equals(" ") && !originalWord.isEmpty()) {
                stack.push(originalWord);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) {
                result.append(" ");
            }

        }
        return result.toString();

    }

    public static void main(String[] args) {
        String s = new ReverseWordsString().reverseWords("a good   example");
        System.out.println(s);
    }
}
