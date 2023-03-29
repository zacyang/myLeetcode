package com.leetcode.second.stackq;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
// 2[ab]   2[a3[b]]
        Stack<Character> stack = new Stack<>();

        char[] target = s.toCharArray();
        for (char c : target) {
            if (c != ']') {
                stack.push(c);
            } else {
                LinkedList<Character> result = new LinkedList<>();
                while (Character.isAlphabetic(stack.peek())) {
                    result.add(stack.pop());
                }
                stack.pop();
//                get the digit
                int numberOfRepeat = 0;
                int power = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {

                    int digit = stack.pop() - '0';
                    numberOfRepeat += digit * (Math.pow(10L, power));

                    power++;

                }

                for (int i = 0; i < numberOfRepeat; i++) {
                    for (int i1 = result.size()-1; i1 >=0; i1--) {
                        stack.push(result.get(i1));
                    }

                }

            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Character character : stack) {
            stringBuilder.append(character);
        }


        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        String s = new DecodeString().decodeString("3[a]2[bc]");
//        String s = new DecodeString().decodeString("3[a]");
        String s = new DecodeString().decodeString("3[a2[c]]");
//        String s = new DecodeString().decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }
}
