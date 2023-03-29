package com.leetcode.second.stackq;

import java.util.Stack;

public class ImplementQueueusingStacks {

    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public ImplementQueueusingStacks() {
        input = new Stack();
        output = new Stack<>();

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(!output.empty()) {
            return output.pop();
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }

        return output.pop();

    }

    public int peek() {
        if(!output.empty()) {
            return output.peek();
        }
        while (!input.isEmpty()) {
            output.push(input.pop());
        }

        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
