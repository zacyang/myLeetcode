package com.leetcode.second.stackq;

import java.util.HashSet;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        HashSet allOperations = new HashSet();
        allOperations.add("+");
        allOperations.add("-");
        allOperations.add("*");
        allOperations.add("/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(allOperations.contains(token)) {
                int firstOperatee = stack.pop();
                int result = 0;
                if(token.equals("+")) {
                    result = firstOperatee + stack.pop();
                } else if (token.equals("-")) {
                    result =  stack.pop() -firstOperatee ;
                } else if (token.equals("*")) {
                    result = firstOperatee * stack.pop();
                } else if (token.equals("/")) {
                    result = stack.pop()/ firstOperatee ;
                }

                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }


        }
        return stack.peek();
    }

    public static void main(String[] args) {
        int i = new EvaluateReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i);
    }
}
