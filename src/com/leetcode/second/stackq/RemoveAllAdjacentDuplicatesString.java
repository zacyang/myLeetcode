package com.leetcode.second.stackq;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesString {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {

            if (!stack.isEmpty() && stack.peek().equals(aChar)) {
                stack.pop();

            } else {
                stack.push(aChar);
            }

        }


        return stack.stream().map(a -> a.toString()).collect(Collectors.joining(""));


    }

    public static void main(String[] args) {
        String abbaca = new RemoveAllAdjacentDuplicatesString().removeDuplicates("abbaca");
        System.out.println(abbaca);
    }
}
