package com.leetcode.second.stackq;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ImplementStackusingQueues {
    Queue<Integer> input;
    Queue<Integer> output;
    Integer top;
    public ImplementStackusingQueues() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    public void push(int x) {
        input.add(x);
        top = x;
    }

    public int pop() {
        while(input.size() > 1) {
            output.add(input.poll());
        }

        Integer result = input.remove();
        while (!output.isEmpty()) {
            top = output.poll();
            input.add(top);
        }

        return result;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return input.isEmpty();
    }
}
