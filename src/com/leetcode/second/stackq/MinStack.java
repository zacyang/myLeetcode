package com.leetcode.second.stackq;

import java.util.Stack;

//LC155
public class MinStack {

    private final Stack<Integer> q;
    private final Stack<Integer> minStack;

    public MinStack() {
        q = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() >=val) {
            minStack.push(val);
        }
        q.push(val);
    }

    public void pop() {
        Integer peek = q.peek();
        if(q.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        q.pop();
    }

    public int top() {
        return q.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
//        minStack1.push(-2);
//        minStack1.push(0);
//        minStack1.push(-1);
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        System.out.println(minStack1.getMin());
        minStack1.pop();
        minStack1.top();
        System.out.println(minStack1.getMin());
    }
}
