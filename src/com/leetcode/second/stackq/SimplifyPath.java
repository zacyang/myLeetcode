package com.leetcode.second.stackq;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");


        Stack<String> stack = new Stack<>();
        for (String s : paths) {
            if (!s.isBlank() && !s.equals("/")) {
                stack.push(s);
            }
        }

        LinkedList<String> strings = new LinkedList<>();
        int balancedCounter = 0;
        while (!stack.isEmpty()) {
            String nextElment = stack.peek();

            if (nextElment.equals("..")) {
                stack.pop();
                balancedCounter--;
                continue;
            } else if (nextElment.equals(".")) {
//                continue;
                stack.pop();
                continue;
            } else {
                if (balancedCounter < 0) {
                    balancedCounter++;
                } else {
                    strings.addFirst(nextElment);
                }

                stack.pop();
            }


        }
        return "/" + String.join("/", strings);

    }

    public static void main(String[] args) {
        String s = new SimplifyPath().simplifyPath("/a/./b/../../c/");
        System.out.println(s);
    }
}
